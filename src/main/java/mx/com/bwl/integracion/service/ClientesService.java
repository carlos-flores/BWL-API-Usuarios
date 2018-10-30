/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.service;

import java.util.ArrayList;
import java.util.List;
import mx.com.bwl.integracion.dao.UsuariosDAO;
import mx.com.bwl.integracion.model.Cliente;
import mx.com.bwl.integracion.model.Respuesta;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    public Object obtenerClientes() {
        List<Cliente>listaClientes = new ArrayList<Cliente>();
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List<Object[]> respList = (List<Object[]>) usuariosDAO.obtenerClientes();
        if (respList != null && !respList.isEmpty()) {
            for (Object[] clientTEMP : respList) {
                Cliente client = new Cliente();
                client.setId(clientTEMP[0] != null ? (Integer) clientTEMP[0] : null);
                client.setCliente(clientTEMP[1] != null ? (String) clientTEMP[1] : null);
                client.setCiudad(clientTEMP[2] != null ? (String) clientTEMP[2] : null);
                client.setEstado(clientTEMP[3] != null ? (String) clientTEMP[3] : null);
                client.setCalle(clientTEMP[4] != null ? (String) clientTEMP[4] : null);
                client.setCp(clientTEMP[5] != null ? (String) clientTEMP[5] : null);
                listaClientes.add(client);
            }
        }
        return new Respuesta(200,true,listaClientes);
    }

    public Object obtenerClientes(String estados) {
        List<Cliente>listaClientes = new ArrayList<Cliente>();
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List<Object[]> respList = (List<Object[]>) usuariosDAO.obtenerClientes(estados);
        if (respList != null && !respList.isEmpty()) {
            for (Object[] clientTEMP : respList) {
                Cliente client = new Cliente();
                client.setId(clientTEMP[0] != null ? (Integer) clientTEMP[0] : null);
                client.setCliente(clientTEMP[1] != null ? (String) clientTEMP[1] : null);
                client.setCiudad(clientTEMP[2] != null ? (String) clientTEMP[2] : null);
                client.setEstado(clientTEMP[3] != null ? (String) clientTEMP[3] : null);
                client.setCalle(clientTEMP[4] != null ? (String) clientTEMP[4] : null);
                client.setCp(clientTEMP[5] != null ? (String) clientTEMP[5] : null);
                listaClientes.add(client);
            }
        }
        return new Respuesta(200,true,listaClientes);
    }
    

}
