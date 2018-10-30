/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Usuario", description = "Representación de un usuario registrado")
public class Usuario {

    @ApiModelProperty(
            value = "Identificador único del kit",
            required = true)
    private int id;

    @ApiModelProperty(
            value = "Nombre de usuario para acceder al sistema",
            required = true)
    private String username;

    @ApiModelProperty(
            value = "Nombre de pila del usuario",
            required = true)
    private String nombre;

    @ApiModelProperty(
            value = "Apellidos del usuario",
            required = true)
    private String apellidos;

    @ApiModelProperty(
            value = "Password del usuario",
            required = true)
    private String pwd;

    @ApiModelProperty(
            value = "Estatus del usuario",
            required = true)
    private boolean status;

    @ApiModelProperty(
            value = "Correo electrónico del usuario",
            required = true)
    private String email;

    @ApiModelProperty(
            value = "Role del usuario",
            required = true)
    private String role;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", nombre=" + nombre + ", apellidos=" + apellidos + ", pwd=" + pwd + ", status=" + status + ", email=" + email + ", role=" + role + '}';
    }

    
}
