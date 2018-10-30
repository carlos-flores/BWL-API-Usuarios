/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class VehiculoNotFoundException extends WebApplicationException {
	private static final long serialVersionUID = -2894269137259898072L;
	
	public VehiculoNotFoundException( final String placa ) {
		super(
			Response
				.status( Status.NOT_FOUND )
				.build()
		);
	}
}
