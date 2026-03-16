package co.edu.demoacademico.asignaturas.model.entity;

import co.edu.demoacademico.programas.model.entity.Programa;
import jakarta.persistence.*;

@Entity
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String codigo;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(nullable = false)
    private Integer creditos;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "programa_id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_asignatura_programa"))
    private Programa programa;

    public Asignatura(){}

    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public Integer getCreditos(){return this.creditos;}
    public void setCreditos(Integer creditos){this.creditos = creditos;}

    public Programa getPrograma(){return this.programa;}
    public void setPrograma(Programa programa){this.programa = programa;}
}
