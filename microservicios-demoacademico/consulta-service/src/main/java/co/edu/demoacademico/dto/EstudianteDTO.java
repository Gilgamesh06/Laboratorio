package co.edu.demoacademico.dto;

public class EstudianteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;

    public EstudianteDTO(){}

    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getApellido(){return this.apellido;}
    public void setApellido(String apellido){this.apellido = apellido;}

    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    public Integer getEdad(){return this.edad;}
    public void setEdad(Integer edad){this.edad = edad;}
}
