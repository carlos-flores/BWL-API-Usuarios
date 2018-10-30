/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UsuarioLogin", description = "Representación de un usuario registrado")
public class UsuarioLogin {

    @ApiModelProperty(
            value = "Nombre de usuario para acceder al sistema",
            required = true)
    private String username;

    @ApiModelProperty(
            value = "Nombre de pila del usuario",
            required = true)
    private String password;


    @ApiModelProperty(
            value = "Estatus del usuario",
            required = true)
    private boolean getToken;


    public UsuarioLogin() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGetToken() {
        return getToken;
    }

    public void setGetToken(boolean getToken) {
        this.getToken = getToken;
    }

    @Override
    public String toString() {
        return "UsuarioLogin{" + "email=" + username + ", password=" + password + ", getToken=" + getToken + '}';
    }

    
}
