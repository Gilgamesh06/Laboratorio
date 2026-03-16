package co.edu.demoacademico.programas.controller;

import co.edu.demoacademico.common.api.ApiResponse;
import co.edu.demoacademico.common.api.ResponseBuilder;
import co.edu.demoacademico.programas.handler.ProgramaHandler;
import co.edu.demoacademico.programas.model.dto.ProgramaCreateDTO;
import co.edu.demoacademico.programas.model.dto.ProgramaDTO;
import co.edu.demoacademico.programas.model.dto.ProgramaUpdateDTO;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    private final ProgramaHandler handler;

    public ProgramaController(ProgramaHandler handler){
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProgramaDTO>> crear(@Valid @RequestBody ProgramaCreateDTO in){
        return ResponseBuilder.created("Programa creado", handler.crear(in));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProgramaDTO>> obtener(@PathVariable Long id){
        return ResponseBuilder.ok("OK", handler.obtener(id));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProgramaDTO>>> obtener(@ParameterObject Pageable pageable){
        return  ResponseBuilder.ok("OK", handler.listar(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProgramaDTO>> actualizar(@PathVariable Long id, @Valid @RequestBody ProgramaUpdateDTO in){
        return ResponseBuilder.ok("Programa Actualizado", handler.actualizar(id, in));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id){
        handler.eliminar(id);
        return ResponseBuilder.ok("Programa eliminado", null);
    }
}
