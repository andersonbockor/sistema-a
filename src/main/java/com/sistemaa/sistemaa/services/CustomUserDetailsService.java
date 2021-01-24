package com.sistemaa.sistemaa.services;

import com.sistemaa.sistemaa.model.Perfil;
import com.sistemaa.sistemaa.model.Usuario;
import com.sistemaa.sistemaa.repository.UsuarioRepository;
import com.sistemaa.sistemaa.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException(String.format("UserNotExist"));
        } else if (!usuario.get().getAtivo()) {
            throw new ObjectNotFoundException(String.format("UserNotEnabled"));
        }
        return new UserRepositoryUserDetails(usuario.get());
    }

    private final List<GrantedAuthority> getGrantedAuthorities(final Collection<Perfil> perfis) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Perfil perfil: perfis) {
            authorities.add(new SimpleGrantedAuthority(perfil.getNome()));
        }
        return authorities;
    }

    public final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Perfil> perfis){
        return getGrantedAuthorities(perfis);
    }

    private final static class UserRepositoryUserDetails extends Usuario implements UserDetails {

        public UserRepositoryUserDetails(Usuario usuario) {
            super(usuario);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {

            final List<Perfil> perfis = new ArrayList<Perfil>();
            perfis.add(getPerfil());
            return perfis;
        }

        @Override
        public String getPassword() {
            return getSenha();
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return getAtivo();
        }
    }
}
