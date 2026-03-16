package co.edu.demoacademico.estudiantes.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EstudianteCreateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    private String email;

    public EstudianteCreateDTO(){}

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getNombre(){
       return  this.nombre = nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
