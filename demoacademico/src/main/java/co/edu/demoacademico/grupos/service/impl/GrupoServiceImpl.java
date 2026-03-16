package co.edu.demoacademico.grupos.service.impl;

import co.edu.demoacademico.common.exception.NotFoundException;
import co.edu.demoacademico.grupos.model.entity.Grupo;
import co.edu.demoacademico.grupos.port.GrupoQueryPort;
import co.edu.demoacademico.grupos.repository.GrupoRepository;
import co.edu.demoacademico.grupos.service.GrupoService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GrupoServiceImpl implements GrupoService, GrupoQueryPort {

    private final GrupoRepository repo;

    public GrupoServiceImpl(GrupoRepository repo){
        this.repo = repo;
    }

    @Override
    public Grupo crear(Grupo g){
        return repo.save(g);
    }

    @Override
    @Transactional
    public Grupo obtenerPorId(Long id){
        return  repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Grupo no encontrado:" + id));
    }

    @Override
    @Transactional
    public Page<Grupo> listar(Pageable pageable){
        return repo.findAll(pageable);
    }

    @Override
    public void eliminar(Long id){
        repo.delete((obtenerPorId(id)));
    }
}
