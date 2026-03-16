package co.edu.demoacademico.grupos.model.dto;

public class GrupoDTO {

    private Long id;
    private String codigoGrupo;
    private Integer cupoMax;
    private Long asignaturaId;
    private String asignaturaNombre;

    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}

    public String getCodigoGrupo(){return this.codigoGrupo;}
    public void  setCodigoGrupo(String codigoGrupo){this.codigoGrupo = codigoGrupo;}

    public Integer getCupoMax() { return cupoMax; }
    public void setCupoMax(Integer cupoMax) { this.cupoMax = cupoMax; }

    public Long getAsignaturaId(){return this.asignaturaId;}
    public void setAsignaturaId(Long asignaturaId){this.asignaturaId = asignaturaId;}

    public String getAsignaturaNombre(){return this.asignaturaNombre;}
    public void setAsignaturaNombre(String asignaturaNombre){this.asignaturaNombre = asignaturaNombre;}
}
