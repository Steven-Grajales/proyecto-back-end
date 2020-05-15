package co.udea.registro.api.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.ZoneId;

public class ActividadWrapper {

    private int codigo;
    private String estado;
    private String curso;
    private String docente;
    private String fecha;
    private int duracion;
    private String semestre;
    private String descripcion;
    private String tipo;

    public ActividadWrapper(){}

    public ActividadWrapper(Actividad actividad){
        this.codigo = actividad.getId();
        this.estado = actividad.getEstado();
        this.curso = actividad.getCurso().getCodigo() + " - " + actividad.getCurso().getNombre();
        this.docente = actividad.getDocente().getId() + " - " + actividad.getDocente().getNombre();
        this.duracion = actividad.getDuracion();
        this.semestre = actividad.getSemestre();
        this.descripcion = actividad.getDescripcion();
        this.tipo = actividad.getTipo();
        LocalDate fecha = actividad.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.fecha = fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
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
}
