package co.edu.demoacademico.asignaturas.controller;

import co.edu.demoacademico.common.api.ApiResponse;
import co.edu.demoacademico.common.api.ResponseBuilder;
import co.edu.demoacademico.asignaturas.handler.AsignaturaHandler;
import co.edu.demoacademico.asignaturas.model.dto.AsignaturaCreateDTO;
import co.edu.demoacademico.asignaturas.model.dto.AsignaturaDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/asignaturas")
public class AsignaturaController {

    private final AsignaturaHandler handler;

    public AsignaturaController(AsignaturaHandler handler){
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AsignaturaDTO>> crear(@Valid @RequestBody AsignaturaCreateDTO in){
        return ResponseBuilder.ok("OK", handler.crear(in));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AsignaturaDTO>>> listar(){
        return ResponseBuilder.ok("Ok", handler.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id){
        handler.eliminar(id);
        return ResponseBuilder.ok("Asignatura eliminar", null);
    }
}
