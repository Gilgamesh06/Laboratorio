package co.edu.demoacademico.matriculas.model.dto;

import java.time.Instant;

public class MatriculaDTO {

    private Long id;
    private Long estudianteId;
    private String estudianteNombre;
    private Long grupoId;
    private String codigoGrupo;
    private Instant fechaRegistro;

    public Long getId(){return this.id;}
    public void setId(Long id){this.id = this.id;}

    public Long getEstudianteId(){return this.estudianteId;}
    public void setEstudianteId(Long estudianteId){this.estudianteId = estudianteId;}

    public String getEstudianteNombre(){return this.estudianteNombre;}
    public void setEstudianteNombre(String estudianteNombre){this.estudianteNombre = estudianteNombre;}

    public Long getGrupoId(){return this.grupoId;}
    public void setGrupoId(Long grupoId){this.grupoId = grupoId;}

    public String getCodigoGrupo(){return this.codigoGrupo;}
    public void setCodigoGrupo(String codigoGrupo){this.codigoGrupo = codigoGrupo;}

    public Instant getFechaRegistro(){return this.fechaRegistro;}
    public void setFechaRegistro(Instant fechaRegistro){this.fechaRegistro = fechaRegistro;}
}
