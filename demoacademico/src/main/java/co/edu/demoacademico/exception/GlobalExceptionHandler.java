package co.edu.demoacademico.exception;
import co.edu.demoacademico.model.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase para centralizar el manejo de excepciones
 * Como tal estaria tambien en la capa Presentación
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EstudianteNotFound.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(EstudianteNotFound ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(IllegalStateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
