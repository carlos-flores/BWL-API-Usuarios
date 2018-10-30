/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Cliente", description = "Representación de un cliente")
public class Cliente {

    @ApiModelProperty(
            value = "Identificador del cliente",
            required = true)
    private int id;

    @ApiModelProperty(
            value = "Razón Social del Cliente",
            required = true)
    private String cliente;

    @ApiModelProperty(
            value = "Ciudad del cliente",
            required = true)
    private String ciudad;

    @ApiModelProperty(
            value = "Estado del cliente",
            required = true)
    private String estado;

    @ApiModelProperty(
            value = "Calle del cliente",
            required = true)
    private String calle;

    @ApiModelProperty(
            value = "Código postal del cliente",
            required = true)
    private String cp;

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cliente=" + cliente + ", ciudad=" + ciudad + ", estado=" + estado + ", calle=" + calle + ", cp=" + cp + '}';
    }

}
