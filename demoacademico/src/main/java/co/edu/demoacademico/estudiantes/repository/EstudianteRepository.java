package co.edu.demoacademico.estudiantes.repository;

import co.edu.demoacademico.estudiantes.model.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * Esta clase pertenece a  acceso a los datos
 */
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    Optional<Estudiante> findByEmail(String email);
}

