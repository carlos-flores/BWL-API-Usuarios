/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class BadRequestException extends WebApplicationException {

    public BadRequestException() {
        super(
                Response.status(Status.BAD_REQUEST).build());
    }
}
