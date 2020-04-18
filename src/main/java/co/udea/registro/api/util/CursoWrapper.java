package co.udea.registro.api.util;

import co.udea.registro.api.model.Curso;

public class CursoWrapper {

    private String codigo;
    private String nombre;
    private String horario;
    private int totalEstudiantes;

    public CursoWrapper(Curso curso) {
        this.codigo = curso.getCodigo();
        this.nombre = curso.getNombre();
        this.horario = curso.getHorario();
        this.totalEstudiantes = curso.getEstudiantes().size();
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getTotalEstudiantes() {
        return totalEstudiantes;
    }

    public void setTotalEstudiantes(int totalEstudiantes) {
        this.totalEstudiantes = totalEstudiantes;
    }
}
