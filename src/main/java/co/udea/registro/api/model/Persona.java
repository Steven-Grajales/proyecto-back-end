package co.udea.registro.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="personas")
public abstract class Persona {

    @Id
    protected String id;

    @NotNull
    protected String nombre;

    @NotNull
    protected String apellido;

    @NotNull
    protected String correo;

    @OneToOne
    @JoinColumn(name = "usuario", nullable = false, unique = true)
    protected CuentaDeUsuario usuario;

    public Persona() {
    }

    public Persona(String id, String nombre, String apellido, String correo, CuentaDeUsuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public CuentaDeUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(CuentaDeUsuario usuario) {
        this.usuario = usuario;
    }
}
