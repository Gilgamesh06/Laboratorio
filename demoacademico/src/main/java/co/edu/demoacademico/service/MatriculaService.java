package co.edu.demoacademico.service;

import co.edu.demoacademico.model.entity.Matricula;

public interface MatriculaService {

    Matricula matricular(Long estudianteId, Long grupoId);
}
