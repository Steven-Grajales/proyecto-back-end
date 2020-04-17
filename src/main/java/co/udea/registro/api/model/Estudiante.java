package co.udea.registro.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante extends Persona {

    @ManyToMany
    @JoinTable(name = "EstudiantesPorCursos", joinColumns = @JoinColumn(name = "estudiante"),
            inverseJoinColumns = @JoinColumn(name = "curso")
    )
    private List<Curso> cursos;

}
