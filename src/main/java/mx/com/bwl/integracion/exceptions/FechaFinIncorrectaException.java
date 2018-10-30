/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class FechaFinIncorrectaException extends WebApplicationException {

    public FechaFinIncorrectaException() {
        super(
                Response.status(403).build());
    }
}
