package pe.cibertec.cloud5011.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.cloud5011.app.model.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}