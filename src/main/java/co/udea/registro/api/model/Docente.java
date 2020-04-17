package co.udea.registro.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="docentes")
public class Docente extends Persona {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private List<Curso> cursos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private List<Actividad> actividades;

    public Docente() {
    }

    public Docente(String id, String nombre, String apellido, String correo, CuentaDeUsuario usuario, List<Curso> cursos,
                   List<Actividad> actividades) {
        super(id, nombre, apellido, correo, usuario);
        this.cursos = cursos;
        this.actividades = actividades;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
