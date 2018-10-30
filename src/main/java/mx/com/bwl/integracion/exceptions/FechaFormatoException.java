/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class FechaFormatoException extends WebApplicationException {

    public FechaFormatoException() {
        super(
                Response.status(401).build());
    }
}
