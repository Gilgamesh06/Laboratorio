package co.edu.demoacademico.model;

import jakarta.persistence.*;


/**
 * No se usa anotaciones como @Getter y @Setter o antocaiones como @Data o @Builder
 * Se crea de forma manual los setter y getters ademas de Constructor vacio.
 * Esto cumple con la condicion de POJO
 */
@Entity
@Table(name = "estudiante", uniqueConstraints = {
        @UniqueConstraint(name = "uk_estudiante_email", columnNames = {"email"})
})
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(nullable = false, length = 120)
    private String apellido;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = false)
    private Integer edad;


    // Constructor
    public Estudiante(){

    }

    // Setter and getters
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
