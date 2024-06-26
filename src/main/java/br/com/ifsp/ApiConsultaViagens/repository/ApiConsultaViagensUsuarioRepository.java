package br.com.ifsp.ApiConsultaViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ifsp.ApiConsultaViagens.models.Usuario;

public interface ApiConsultaViagensUsuarioRepository extends JpaRepository<Usuario, Long> {
}

