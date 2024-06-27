package br.com.ifsp.ApiConsultaViagens.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifsp.ApiConsultaViagens.models.Usuario;
import br.com.ifsp.ApiConsultaViagens.repository.UsuarioRepository;

@Service
public class ImplUsuarioService implements ServiceUsuario {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ImplUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public String createUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuário criado com sucesso!";
    }

    @Override
    public String updateUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Usuário atualizado com sucesso!";
    }

    @Override
    public String deleteUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
        return "Usuário deletado com sucesso!";
    }

    @Override
    public Usuario getUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }
}

