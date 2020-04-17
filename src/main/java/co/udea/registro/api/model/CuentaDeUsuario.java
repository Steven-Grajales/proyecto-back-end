package co.udea.registro.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cuentas_de_usuario")
public class CuentaDeUsuario {

    @Id
    private String usuario;

    @NotNull
    private String contaseña;

    @OneToOne
    @JoinColumn(name = "id_persona", nullable = false, unique = true)
    private Persona persona;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rol", nullable = false)
    private Rol rol;

    public CuentaDeUsuario() {
    }

    public CuentaDeUsuario(String usuario, String contaseña, Persona persona, Rol rol) {
        this.usuario = usuario;
        this.contaseña = contaseña;
        this.persona = persona;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContaseña() {
        return contaseña;
    }

    public void setContaseña(String contaseña) {
        this.contaseña = contaseña;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
