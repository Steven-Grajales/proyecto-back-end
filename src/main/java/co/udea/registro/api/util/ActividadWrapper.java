package co.udea.registro.api.util;

import co.udea.registro.api.model.Actividad;

public class ActividadWrapper {

    private String codigo;
    private String estado;
    private String curso;
    private String docente;
    private String fecha;
    private String duracion;
    private String semestre;
    private String descripcion;

    public ActividadWrapper(Actividad actividad){
        this.codigo = actividad.getId();
        this.estado = actividad.getEstado();
        this.curso = actividad.getCurso().getCodigo() + " - " + actividad.getCurso().getNombre();
        this.docente = actividad.getDocente().getNombre();
        this.fecha = actividad.getFecha().toString();
        this.duracion = actividad.getDuracion();
        this.semestre = actividad.getSemestre();
        this.descripcion = actividad.getDescripcion();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
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
}
