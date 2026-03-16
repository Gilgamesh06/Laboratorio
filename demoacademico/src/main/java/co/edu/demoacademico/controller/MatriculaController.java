package co.edu.demoacademico.controller;

import co.edu.demoacademico.api.ApiResponse;
import co.edu.demoacademico.api.ResponseBuilder;
import co.edu.demoacademico.handler.MatriculaHandler;
import co.edu.demoacademico.model.dto.matricula.MatriculaCreateDTO;
import co.edu.demoacademico.model.dto.matricula.MatriculaDTO;
import co.edu.demoacademico.model.entity.Matricula;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaHandler handler;

    public MatriculaController(MatriculaHandler handler){
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MatriculaDTO>> matricular(@Valid @RequestBody MatriculaCreateDTO in){
        return ResponseBuilder.created("Matricula registrada", handler.matricular(in));
    }
}
