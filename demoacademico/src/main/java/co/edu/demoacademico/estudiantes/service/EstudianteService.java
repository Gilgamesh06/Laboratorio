package co.edu.demoacademico.estudiantes.service;

import co.edu.demoacademico.estudiantes.model.entity.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public  interface EstudianteService {

    Estudiante crear(Estudiante estudiante);
    Estudiante obtenerPorId(Long id);
    Estudiante obtenerPorEmail(String email);
    Page<Estudiante> listar(Pageable pageable);
    Estudiante actualizar(Long id, Estudiante estudiante);
    void  eliminar(Long id);
}
