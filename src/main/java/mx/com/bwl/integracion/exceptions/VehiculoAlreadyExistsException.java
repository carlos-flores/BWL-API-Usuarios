/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class VehiculoAlreadyExistsException extends WebApplicationException {

    private static final long serialVersionUID = 6817489620338221395L;

    public VehiculoAlreadyExistsException(final String placa) {
        super(
                Response.status(Status.CONFLICT).build());
    }
}