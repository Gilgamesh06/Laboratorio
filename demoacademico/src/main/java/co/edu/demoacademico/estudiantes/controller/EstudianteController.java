package co.edu.demoacademico.estudiantes.controller;

import co.edu.demoacademico.common.api.ApiResponse;
import co.edu.demoacademico.common.api.ResponseBuilder;
import co.edu.demoacademico.estudiantes.model.dto.EstudianteCreateDTO;
import co.edu.demoacademico.estudiantes.model.dto.EstudianteDTO;
import co.edu.demoacademico.estudiantes.model.dto.EstudianteUpdateDTO;
import co.edu.demoacademico.estudiantes.handler.EstudianteHandler;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteHandler handler;

    public EstudianteController(EstudianteHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EstudianteDTO>> crear(@Valid @RequestBody EstudianteCreateDTO in) {
        return ResponseBuilder.created("Estudiante creado", handler.crear(in));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<EstudianteDTO>> obtenerPorEmail(@PathVariable @Valid @NotBlank(message = "El email no debe ser vacio")
                                                                      @Email(message = "Formato de email Invalido") String email){
        return ResponseBuilder.ok("Ok", handler.obtenerPorEmail(email));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EstudianteDTO>> obtener(@PathVariable Long id) {
        return ResponseBuilder.ok("OK", handler.obtener(id));
    }

    // Ejemplo: /api/estudiantes?page=0&size=5&sort=nombre,asc
    @GetMapping
    public ResponseEntity<ApiResponse<Page<EstudianteDTO>>> listar(@ParameterObject Pageable pageable) {
        return ResponseBuilder.ok("OK", handler.listar(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EstudianteDTO>> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody EstudianteUpdateDTO in
    ) {
        return ResponseBuilder.ok("Estudiante actualizado", handler.actualizar(id, in));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id) {
        handler.eliminar(id);
        return ResponseBuilder.ok("Estudiante eliminado", null);
    }
}