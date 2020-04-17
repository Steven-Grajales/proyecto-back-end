package co.udea.registro.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private String tipo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<CuentaDeUsuario> usuarios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<Permiso> permisos;

    public Rol() {
    }

    public Rol(String tipo, List<CuentaDeUsuario> usuarios, List<Permiso> permisos) {
        this.tipo = tipo;
        this.usuarios = usuarios;
        this.permisos = permisos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<CuentaDeUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<CuentaDeUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
}
