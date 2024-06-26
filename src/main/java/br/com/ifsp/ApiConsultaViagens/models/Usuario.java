package br.com.ifsp.ApiConsultaViagens.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_info")
public class Usuario {

    @Id
    private Long usuarioId;
    private String usuario;
    private String senha;

    public Usuario() {}

    public Usuario(Long usuarioId, String usuario, String senha) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

