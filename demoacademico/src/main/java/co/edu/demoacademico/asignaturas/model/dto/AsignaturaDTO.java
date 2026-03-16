package co.edu.demoacademico.asignaturas.model.dto;

public class AsignaturaDTO {

    private Long id;
    private String codigo;
    private String nombre;
    private Integer creditos;
    private Long programaId;
    private String programaNombre;

    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}

    public String getCodigo(){return this.codigo;}
    public void setCodigo(String codigo){this.codigo = codigo;}

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public Integer getCreditos(){return this.creditos;}
    public void setCreditos(Integer creditos){this.creditos = creditos;}

    public Long getProgramaId(){return this.programaId;}
    public void setProgramaId(Long programaId){this.programaId = programaId;}

    public String getProgramaNombre(){return this.programaNombre;}
    public void setProgramaNombre(String programaNombre){this.programaNombre = programaNombre;}
}
