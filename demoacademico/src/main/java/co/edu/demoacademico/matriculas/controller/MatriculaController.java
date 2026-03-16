package co.edu.demoacademico.matriculas.controller;

import co.edu.demoacademico.common.api.ApiResponse;
import co.edu.demoacademico.common.api.ResponseBuilder;
import co.edu.demoacademico.matriculas.handler.MatriculaHandler;
import co.edu.demoacademico.matriculas.model.dto.MatriculaCreateDTO;
import co.edu.demoacademico.matriculas.model.dto.MatriculaDTO;
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
