package br.com.ifsp.ApiConsultaViagens.service;

import java.util.List;
import br.com.ifsp.ApiConsultaViagens.models.Usuario;

public interface ServiceUsuario {
    String createUsuario(Usuario usuario);
    String updateUsuario(Usuario usuario);
    String deleteUsuario(Long usuarioId);
    Usuario getUsuario(Long usuarioId);
    List<Usuario> getAllUsuario();
}
