package co.edu.demoacademico.matriculas.service;

import co.edu.demoacademico.matriculas.model.entity.Matricula;

public interface MatriculaService {

    Matricula matricular(Long estudianteId, Long grupoId);
}
