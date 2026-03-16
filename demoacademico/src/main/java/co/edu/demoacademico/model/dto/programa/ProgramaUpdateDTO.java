package co.edu.demoacademico.model.dto.programa;

import jakarta.validation.constraints.NotBlank;

public class ProgramaUpdateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}
}
