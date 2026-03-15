package co.edu.demoacademico.service;

import co.edu.demoacademico.exception.EstudianteNotFound;
import co.edu.demoacademico.model.dto.EmailRequest;
import co.edu.demoacademico.model.entity.Estudiante;
import co.edu.demoacademico.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Esta clase pertenece a la capa de lógica
 */
@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante crear(Estudiante estudiante) {

        // ----------------------------
        // ZONA DE LÓGICA DE NEGOCIO:
        // Regla: email único
        // ----------------------------
        repository.findByEmail(estudiante.getEmail())
                .ifPresent(e -> {
                    throw new IllegalStateException("Email ya registrado");
                });

        // ============================
        // ZONA DE ACCESO A LA BD:
        // Persistencia vía Repository
        // ============================
        return repository.save(estudiante);
    }

    public List<Estudiante> listar() {
        // ============================
        // ZONA DE ACCESO A LA BD:
        // Consulta vía Repository
        // ============================
        return repository.findAll();
    }

    public Estudiante BusquedaDeEstudiantePorCorreo(EmailRequest emailRequest){
        return repository.findByEmail(emailRequest.getEmail())
                .orElseThrow(() -> new EstudianteNotFound("Estudiante con correo: "+ emailRequest.getEmail() + " No econtrado."));
    }
}
