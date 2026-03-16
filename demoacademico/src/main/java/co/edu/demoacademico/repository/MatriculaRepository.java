package co.edu.demoacademico.repository;

import co.edu.demoacademico.model.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    boolean existsByEstudianteIdAndGrupoId(Long estudianteId, Long grupoId);
    long countByGrupoId(Long grupoId);
}
