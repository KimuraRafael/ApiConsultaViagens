package br.com.ifsp.ApiConsultaViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ifsp.ApiConsultaViagens.models.Passagem;

public interface ApiConsultaViagensRepository extends JpaRepository<Passagem, Long> {
}
