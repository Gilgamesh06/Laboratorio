package co.edu.demoacademico.programas.model.dto;

import jakarta.validation.constraints.NotBlank;

public class ProgramaCreateDTO {

    @NotBlank(message = "El codigo es obligatorio")
    private String codigo;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    public String getCodigo(){return this.codigo;}
    public void setCodigo(String codigo){this.codigo = codigo;}

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}
}
