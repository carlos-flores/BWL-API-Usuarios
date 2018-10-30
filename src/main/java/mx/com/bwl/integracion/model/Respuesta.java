/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.bwl.integracion.model;

/**
 *
 * @author carlitos
 */
public class Respuesta {
    private int status;
    private boolean ok;
    private Object detalle;

    public Respuesta() {
    }

    public Respuesta(int status, boolean ok, Object detalle) {
        this.status = status;
        this.ok = ok;
        this.detalle = detalle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Object getDetalle() {
        return detalle;
    }

    public void setDetalle(Object detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "status=" + status + ", ok=" + ok + ", detalle=" + detalle + '}';
    }

    
}
