package co.edu.demoacademico.matriculas.service.impl;

import co.edu.demoacademico.common.exception.BusinessException;
import co.edu.demoacademico.estudiantes.model.entity.Estudiante;
import co.edu.demoacademico.estudiantes.port.EstudianteQueryPort;
import co.edu.demoacademico.grupos.model.entity.Grupo;
import co.edu.demoacademico.grupos.port.GrupoQueryPort;
import co.edu.demoacademico.matriculas.model.entity.Matricula;
import co.edu.demoacademico.matriculas.repository.MatriculaRepository;
import co.edu.demoacademico.matriculas.service.MatriculaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MatriculaServiceImpl implements MatriculaService {

    private final EstudianteQueryPort estudiantePort;
    private final GrupoQueryPort grupoPort;
    private final MatriculaRepository matriculaRepo;

    public MatriculaServiceImpl(EstudianteQueryPort estudiantePort,
                                GrupoQueryPort grupoPort,
                                MatriculaRepository matriculaRepo){
        this.estudiantePort = estudiantePort;
        this.grupoPort = grupoPort;
        this.matriculaRepo = matriculaRepo;
    }

    @Override
    public Matricula matricular(Long estudianteId, Long grupoId){

        // Existencia se valida por contrato público (y lanza NotFound desde el módulo dueño)
        Estudiante estudiante = estudiantePort.obtenerPorId(estudianteId);
        Grupo grupo = grupoPort.obtenerPorId(grupoId);

        // no duplicado
        if(matriculaRepo.existsByEstudianteIdAndGrupoId(estudianteId, grupoId)){
            throw new BusinessException("El estudiante ya está matriculado en ese grupo");
        }

        // cupo
        long matriculados = matriculaRepo.countByGrupoId(grupoId);
        if(matriculados >= grupo.getCupoMax()){
            throw new BusinessException("El grupo no tiene cupo disponible");
        }

        Matricula matricula = new Matricula();
        matricula.setEstudiante(estudiante);
        matricula.setGrupo(grupo);
        return matriculaRepo.save(matricula);
    }
}
