package co.udea.registro.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="actividades")
public class Actividad {

    @Id
    private int id;

    @NotNull
    private String semestre;

    @NotNull
    private String duracion;

    @NotNull
    private Date fecha;

    @NotNull
    private String descripcion;

    @NotNull
    private String tipo;

    @NotNull
    private String estado;

    @JoinColumn(name = "docente", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Docente docente;

    @JoinColumn(name = "curso", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Curso curso;

    public Actividad() {
    }

    public Actividad(int id, String semestre, String duracion, Date fecha, String descripcion, String tipo,
                     String estado, Docente docente, Curso curso) {
        this.id = id;
        this.semestre = semestre;
        this.duracion = duracion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.docente = docente;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
