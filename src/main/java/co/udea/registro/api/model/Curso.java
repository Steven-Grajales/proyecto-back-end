package co.udea.registro.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="cursos")
public class Curso {

    @Id
    private String codigo;

    @NotNull
    private String nombre;

    @NotNull
    private String estado;

    @NotNull
    private String semestre;

    @NotNull
    private String horario;

    @JoinColumn(name = "docente", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Docente docente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Actividad> actividades;

    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes;

    public Curso() {}

    public Curso(String codigo, String nombre, String estado, String semestre, Docente docente, String horario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.semestre = semestre;
        this.docente = docente;
        this.horario = horario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
