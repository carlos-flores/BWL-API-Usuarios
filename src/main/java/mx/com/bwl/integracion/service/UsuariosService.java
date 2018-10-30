/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mx.com.bwl.integracion.dao.UsuariosDAO;
import mx.com.bwl.integracion.model.Usuario;
import mx.com.bwl.integracion.exceptions.NotFoundException;
import mx.com.bwl.integracion.model.Respuesta;
import mx.com.bwl.integracion.model.Tarea;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    private List<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public Collection<Usuario> getUsuarios() {
        listaUsuarios = new ArrayList<Usuario>();
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List<Object[]> listaUs = (List<Object[]>) usuariosDAO.obtenerUsuarios();
        if (listaUs != null && !listaUs.isEmpty()) {
            for (Object[] user : listaUs) {
                Usuario userTemp = new Usuario();
                userTemp.setId(user[0] != null ? (Integer) user[0] : null);
                userTemp.setUsername(user[1] != null ? (String) user[1] : null);
                userTemp.setNombre(user[2] != null ? (String) user[2] : null);
                userTemp.setApellidos(user[3] != null ? (String) user[3] : null);
                userTemp.setPwd(user[4] != null ? (String) user[4] : null);
                userTemp.setStatus(user[5] != null ? (boolean) user[5] : null);
                userTemp.setEmail(user[6] != null ? (String) user[6] : null);
                userTemp.setRole(user[7] != null ? (String) user[7] : null);
                listaUsuarios.add(userTemp);
            }
            return listaUsuarios;
        }

        return listaUsuarios;
    }

    
    public Usuario getByID(final int id) {
        UsuariosDAO usuarioDAO = new UsuariosDAO();
        Object[] kit = (Object[]) usuarioDAO.obtenerUsuario(id);
        if (kit != null) {
            Usuario userTemp = new Usuario();
            userTemp.setId(kit[0] != null ? (Integer) kit[0] : null);
            userTemp.setUsername(kit[1] != null ? (String) kit[1] : null);
            userTemp.setNombre(kit[2] != null ? (String) kit[2] : null);
            userTemp.setApellidos(kit[3] != null ? (String) kit[3] : null);
            userTemp.setPwd(kit[4] != null ? (String) kit[4] : null);
            userTemp.setStatus(kit[5] != null ? (boolean) kit[5] : null);
            userTemp.setEmail(kit[6] != null ? (String) kit[6] : null);
            userTemp.setRole(kit[7] != null ? (String) kit[7] : null);
            return userTemp;
        }
        throw new NotFoundException();
    }

    public Object getByUsernamePassword(final String username, final String password, final boolean generarToken) {
        UsuariosDAO usuarioDAO = new UsuariosDAO();
        Object[] usuario = (Object[]) usuarioDAO.obtenerUsuarioPorUsernamePassword(username, password);
        if (usuario != null) {
            if (generarToken) {
                return new Respuesta(200, true, "1234567890");
            } else {
                Usuario userTemp = new Usuario();
                userTemp.setId(usuario[0] != null ? (Integer) usuario[0] : null);
                userTemp.setUsername(usuario[1] != null ? (String) usuario[1] : null);
                userTemp.setNombre(usuario[2] != null ? (String) usuario[2] : null);
                userTemp.setApellidos(usuario[3] != null ? (String) usuario[3] : null);
                userTemp.setPwd("**********");
                userTemp.setStatus(usuario[5] != null ? (boolean) usuario[5] : null);
                userTemp.setEmail(usuario[6] != null ? (String) usuario[6] : null);
                userTemp.setRole(usuario[7] != null ? (String) usuario[7] : null);
                return new Respuesta(200, true, userTemp);
            }

        } else {
            return new Respuesta(400, false, "Usuario no encontrado o inactivo");
        }
    }
    
    public Object creandoTarea(final Tarea tarea) {
        UsuariosDAO usuarioDAO = new UsuariosDAO();
        Object resp = usuarioDAO.crearTarea(tarea);
        if (resp != null) {
                return new Respuesta(200, true, "Se ha creado la tarea");
        } else {
            return new Respuesta(400, false, "NO se ha creado la tarea");
        }
    }

    public Object getTareas(int usuario) {
        List<Tarea> listaTareas = new ArrayList<Tarea>();
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List<Object[]> listaTask = (List<Object[]>) usuariosDAO.obtenerTareas(usuario);
        if (listaTask != null && !listaTask.isEmpty()) {
            for (Object[] user : listaTask) {
                Tarea tareaTEMP = new Tarea();
                tareaTEMP.setId(user[0] != null ? (Integer) user[0] : null);
                tareaTEMP.setTitulo(user[1] != null ? (String) user[1] : null);
                tareaTEMP.setDescripcion(user[2] != null ? (String) user[2] : null);
                tareaTEMP.setFechaentrega(user[3] != null ? (Timestamp) user[3] : null);
                listaTareas.add(tareaTEMP);
            }
   
        }
        return new Respuesta(200,true,listaTareas);
    }

}
