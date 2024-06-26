package br.com.ifsp.ApiConsultaViagens.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ifsp.ApiConsultaViagens.models.Usuario;
import br.com.ifsp.ApiConsultaViagens.service.ServiceUsuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioAPIService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioAPIService.class);

    private final ServiceUsuario serviceUsuario;

    @Autowired
    public UsuarioAPIService(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @GetMapping("/{usuarioId}")
    public Object getUsuario(@PathVariable Long usuarioId) {
        logger.info("Chamando getUsuario com usuarioId: " + usuarioId);
        Usuario usuario = serviceUsuario.getUsuario(usuarioId);
        if (usuario != null) {
            return usuario;
        } else {
            return "Usuário não encontrado!";
        }
    }

    @GetMapping
    public List<Usuario> getAllUsuario() {
        return serviceUsuario.getAllUsuario();
    }

    @PostMapping
    public String createUsuario(@RequestBody Usuario usuario) {
        logger.info("Chamando createUsuario com usuarioId: " + usuario.getUsuarioId());
        return serviceUsuario.createUsuario(usuario);
    }

    @PutMapping
    public String updateUsuario(@RequestBody Usuario usuario) {
        logger.info("Chamando updateUsuario com usuarioId: " + usuario.getUsuarioId());
        return serviceUsuario.updateUsuario(usuario);
    }

    @DeleteMapping("/{usuarioId}")
    public String deleteUsuario(@PathVariable Long usuarioId) {
        logger.info("Chamando deleteUsuario com usuarioId: " + usuarioId);
        return serviceUsuario.deleteUsuario(usuarioId);
    }
}
