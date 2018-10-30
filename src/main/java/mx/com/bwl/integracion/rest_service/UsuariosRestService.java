/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.rest_service;

import ch.qos.logback.classic.util.ContextInitializer;
import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import mx.com.bwl.integracion.model.Respuesta;
import mx.com.bwl.integracion.model.Tarea;
import mx.com.bwl.integracion.model.Usuario;
import mx.com.bwl.integracion.model.UsuarioLogin;
import mx.com.bwl.integracion.service.UsuariosService;

@Path("/usuarios")
@Api(value = "/usuarios", description = "API para el manejo de USUARIOS")
public class UsuariosRestService {

    @Inject
    private UsuariosService usuarioService;

    @Produces({MediaType.APPLICATION_JSON})
    @GET
    @ApiOperation(
            value = "Lista de usuarios",
            notes = "Devuelve una lista con todos los usuarios registrados en el sistema AdminBWL",
            response = Usuario.class,
            responseContainer = "List")
    public Collection< Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @GET
    @ApiOperation(
            value = "Obtener un usuario",
            notes = "Busca un usuario por medio de su ID",
            response = Usuario.class)
    @ApiResponses({
        @ApiResponse(code = 404, message = "No existe usuario registrado")
    })
    public Usuario getKit(
            @ApiParam(value = "Identificador de usuario", required = true)
            @PathParam("id") final int id) {
        return usuarioService.getByID(id);
    }

    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/create")
    @POST
    @ApiOperation(
            value = "Crear un usuario",
            notes = "Crea un usuario con los datos que se pasan por medio de post",
            response = Usuario.class)
    public Usuario createUser(Usuario usuario) {
        System.out.println(usuario);
        return usuario;
    }

    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/login")
    @POST
    @ApiOperation(
            value = "Login de un usuario",
            notes = "Permite ")
    public Object login(UsuarioLogin usuario) {
        System.out.println("Executando LOGIN...");
        System.out.println(usuario);
        return usuarioService.getByUsernamePassword(usuario.getUsername(), "{noop}"+usuario.getPassword(), usuario.isGetToken());
    }
    
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/tareas/{id}")
    @GET
    @ApiOperation(
            value = "Tareas de Usuario",
            notes = "Permite devolver una lista de tareas asignadas a un usuario")
    public Object obtenerTareas(@ApiParam(value = "Identificador de usuario", required = true)
            @PathParam("id") final int id) {
        System.out.println("Executando Obtener tareas...");
        System.out.println(id);
        return usuarioService.getTareas(id);
    }
    
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/tareas/create")
    @POST
    @ApiOperation(
            value = "Crear tarea",
            notes = "Permite crear una nueva tarea asociada a un usuario")
    public Object createTarea(Tarea tarea) {
        System.out.println("Creando Tarea...");
        System.out.println(tarea);
        return usuarioService.creandoTarea(tarea);
    }

    
    
}
