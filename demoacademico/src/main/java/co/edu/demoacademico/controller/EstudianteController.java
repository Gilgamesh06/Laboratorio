package co.edu.demoacademico.controller;

import co.edu.demoacademico.model.dto.EmailRequest;
import co.edu.demoacademico.model.entity.Estudiante;
import co.edu.demoacademico.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase pertenece a la capa de presentación
 */
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @PostMapping
    public Estudiante crear(@Valid @RequestBody Estudiante estudiante) {
        return service.crear(estudiante);
    }

    @GetMapping
    public List<Estudiante> listar() {
        return service.listar();
    }

    @GetMapping("/email")
    public ResponseEntity<Estudiante> BusquedaDeEstudiantePorCorreo(@Valid @RequestBody EmailRequest emailRequest){
        Estudiante estudiante = service.BusquedaDeEstudiantePorCorreo(emailRequest);
        return  ResponseEntity.ok(estudiante);
    }

}