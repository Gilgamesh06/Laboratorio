package co.edu.demoacademico.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstudianteCreateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es valido")
    private String email;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 1, message = "La edad minima es 1")
    private Integer edad;

    public EstudianteCreateDTO(){}

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getApellido(){return this.apellido;}
    public void setApellido(String apellido){this.apellido = apellido;}

    public String getEmail(){return this.email;}
    public void  setEmail(String email){this.email = email;}

    public Integer getEdad() {return this.edad;}
    public void setEdad(Integer edad){this.edad = edad;}
}
