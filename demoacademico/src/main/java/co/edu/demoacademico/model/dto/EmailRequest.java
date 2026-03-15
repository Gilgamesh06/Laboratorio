package co.edu.demoacademico.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Esta clase pertenece a la capa de acceso a las datos
 */
public class EmailRequest {

    @NotBlank(message = "El correo no puede ser vacio.")
    @Email(message = "Debe tener formato de correo.")
    private String email;

    public EmailRequest(){}

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
