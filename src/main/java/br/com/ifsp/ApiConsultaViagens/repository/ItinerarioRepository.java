package br.com.ifsp.ApiConsultaViagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ifsp.ApiConsultaViagens.models.Itinerario;

public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {
}
