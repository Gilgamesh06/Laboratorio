package co.edu.demoacademico.repository;

import co.edu.demoacademico.model.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * Esta clase pertenece a  acceso a los datos
 */
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // ============================
    // ZONA DE ACCESO A LA BD (JPA)
    // ============================
    Optional<Estudiante> findByEmail(String email);
}

