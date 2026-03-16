package co.edu.demoacademico.service.impl;

import co.edu.demoacademico.exception.NotFoundException;
import co.edu.demoacademico.model.entity.Asignatura;
import co.edu.demoacademico.repository.AsignaturaRepository;
import co.edu.demoacademico.service.AsignaturaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository repo;

    public AsignaturaServiceImpl(AsignaturaRepository repo){
        this.repo = repo;
    }

    @Override
    public Asignatura crear(Asignatura a){
        return repo.save(a);
    }

    @Override
    @Transactional
    public Asignatura obtenerPorId(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Asignatura no encontrada: "+ id));
    }

    @Override
    @Transactional
    public List<Asignatura> listar(){
        return repo.findAll();
    }

    @Override
    public void eliminar(Long id){
        repo.delete(obtenerPorId(id));
    }
}
