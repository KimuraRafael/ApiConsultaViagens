package br.com.ifsp.ApiConsultaViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ifsp.ApiConsultaViagens.models.Viagem;

public interface ApiConsultaViagensViagensRepository extends JpaRepository<Viagem, Long> {
}
