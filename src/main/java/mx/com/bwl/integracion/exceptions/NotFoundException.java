/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class NotFoundException extends WebApplicationException {

    public NotFoundException() {
        super(
                Response.status(Status.NOT_FOUND).build());
    }
}
