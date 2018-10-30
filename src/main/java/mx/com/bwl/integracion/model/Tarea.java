/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;

@ApiModel(value = "Tarea", description = "Representación de una tarea")
public class Tarea {

    @ApiModelProperty(
            value = "Identificador de la tarea",
            required = true)
    private int id;

    @ApiModelProperty(
            value = "Nombre de la tarea",
            required = true)
    private String titulo;

    @ApiModelProperty(
            value = "Descripción de la tarea",
            required = true)
    private String descripcion;

    @ApiModelProperty(
            value = "Fecha de entrega de la tarea",
            required = true)
    private Timestamp fechaentrega;
    
    @ApiModelProperty(
            value = "Usuario asignado a la tarea",
            required = true)
    private int usuario;

    public Tarea() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Timestamp fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaentrega=" + fechaentrega + ", usuario=" + usuario + '}';
    }

    
}
