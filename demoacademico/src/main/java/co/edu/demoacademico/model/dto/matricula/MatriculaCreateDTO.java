package co.edu.demoacademico.model.dto.matricula;

import jakarta.validation.constraints.NotNull;

public class MatriculaCreateDTO {

    @NotNull(message = "estudianteId es obligatorio")
    private Long estudianteId;

    @NotNull(message = "grupoId es obligatorio")
    private Long grupoId;

    public Long getEstudianteId(){return this.estudianteId;}
    public void setEstudianteId(Long estudianteId){this.estudianteId = estudianteId;}

    public Long getGrupoId(){return this.grupoId;}
    public void setGrupoId(Long grupoId){this.grupoId = grupoId;}
}
