/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.rest_service;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import javax.ws.rs.PathParam;
import mx.com.bwl.integracion.service.ClientesService;

@Path("/clientes")
@Api(value = "/clientes", description = "API para el manejo de CLIENTES")
public class ClientesRestService {

    @Inject
    private ClientesService clientesService;

    
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/")
    @GET
    @ApiOperation(
            value = "Obtener clientes",
            notes = "Devuelve una lista de todos los clientes")
    public Object obtenerClientes() {
        System.out.println("ObtenerClientes...");
        return clientesService.obtenerClientes();
    }
    
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{estados}")
    @GET
    @ApiOperation(
            value = "Obtener clientes por estado",
            notes = "Devuelve una lista de todos los clientes por estados")
    public Object obtenerClientesPorEstados(@ApiParam(value = "Estados a buscar", required = true)
            @PathParam("estados") final String estados) {
        System.out.println("Executando Obtener clientes por estado...");
        System.out.println(estados);
        return clientesService.obtenerClientes(estados);
    }
    
}
