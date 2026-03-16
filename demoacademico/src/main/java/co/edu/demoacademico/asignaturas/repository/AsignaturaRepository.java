package co.edu.demoacademico.asignaturas.repository;

import co.edu.demoacademico.asignaturas.model.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
