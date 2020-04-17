package co.udea.registro.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="permisos")
public class Permiso {

    @Id
    private String codigo;

    @NotNull
    private String descripcion;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rol", nullable = false)
    private Rol rol;

    public Permiso() {
    }

    public Permiso(String codigo, String descripcion, Rol rol) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.rol = rol;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
