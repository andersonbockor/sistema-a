package com.sistemaa.sistemaa.api;


//import com.sistemaa.sistemaa.dto.UsuarioDTO;
import com.sistemaa.sistemaa.dto.UsuarioDTO;
import com.sistemaa.sistemaa.model.Perfil;
import com.sistemaa.sistemaa.model.Usuario;
import com.sistemaa.sistemaa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }

    @GetMapping("/{id}/perfil")
    public ResponseEntity<Perfil> findPerfil(@PathVariable Long id ){
        Usuario usuario = usuarioService.findById(id);

        return ResponseEntity.ok().body(usuario.getPerfil());
    }
}
