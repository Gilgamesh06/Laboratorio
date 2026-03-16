package co.edu.demoacademico.estudiantes.service.impl;

import co.edu.demoacademico.common.exception.BusinessException;
import co.edu.demoacademico.common.exception.NotFoundException;
import co.edu.demoacademico.estudiantes.model.entity.Estudiante;
import co.edu.demoacademico.estudiantes.port.EstudianteQueryPort;
import co.edu.demoacademico.estudiantes.repository.EstudianteRepository;
import co.edu.demoacademico.estudiantes.service.EstudianteService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class EstudianteServiceImpl implements EstudianteService, EstudianteQueryPort {

    private final EstudianteRepository repo;

    public EstudianteServiceImpl(EstudianteRepository repo){
        this.repo = repo;
    }

    @Override
    public Estudiante crear(Estudiante e){
        if(repo.existsByEmail(e.getEmail())){
            throw new BusinessException("Ya existe un estudiante con ese email");
        }
        return repo.save(e);
    }

    @Override
    @Transactional
    public Estudiante obtenerPorId(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado: "+ id));

    }

    @Override
    @Transactional
    public Estudiante obtenerPorEmail(String email){
        return repo.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(("Estudiante no encontrado")));
    }

    @Override
    @Transactional
    public Page<Estudiante> listar(Pageable pageable){
        return repo.findAll(pageable);
    }

    @Override
    public Estudiante actualizar(Long id, Estudiante e){
        Estudiante actual = obtenerPorId(id);

        if(repo.existsByEmailAndIdNot(e.getEmail(), id)){
            throw new BusinessException("El email ya lo usa otro Estudiante");
        }
        actual.setNombre(e.getNombre());
        actual.setEmail(e.getEmail());
        return repo.save(actual);
    }

    @Override
    public void eliminar(Long id){
        Estudiante actual = obtenerPorId(id);
        repo.delete(actual);
    }

}
