/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class RangoFechasException extends WebApplicationException {

    public RangoFechasException() {
        super(
                Response.status(402).build());
    }
}
