package br.com.dev.mscambio.repositories;

import br.com.dev.mscambio.models.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio,Long> {

    Cambio findByFromAndTo(String from, String to);

}
