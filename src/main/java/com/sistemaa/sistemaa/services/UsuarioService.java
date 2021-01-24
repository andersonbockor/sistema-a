package com.sistemaa.sistemaa.services;

import com.sistemaa.sistemaa.model.Usuario;
import com.sistemaa.sistemaa.repository.UsuarioRepository;
import com.sistemaa.sistemaa.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Long id) {
        Optional<Usuario> user = usuarioRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
}
