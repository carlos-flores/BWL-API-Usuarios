/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.bwl.integracion.dao;

import java.util.Date;
import java.util.List;
import mx.com.bwl.integracion.model.Tarea;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlos
 */
public class UsuariosDAO {

    private static Logger log = Logger.getLogger("Negocio");
    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    public List obtenerUsuarios() {
        List resp = null;
        iniciaOperacion();
        try {
            // Se busca el dato mas reciente de la unidad
            String sql = "select "
                    + "		id, "
                    + "		username,"
                    + "		nombre, "
                    + "		apellidos,"
                    + "		pwd,"
                    + "		status,"
                    + "		email,"
                    + "		role "
                    + "from usuarios ";
            SQLQuery query = sesion.createSQLQuery(sql);
            resp = (List<Object[]>) query.list();
            tx.commit();
        } catch (HibernateException he) {
            log.info(he.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } finally {
            if (sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    public List obtenerClientes() {
        List resp = null;
        iniciaOperacion();
        try {
            // Se busca el dato mas reciente de la unidad
            String sql = "select * from clientes ";
            SQLQuery query = sesion.createSQLQuery(sql);
            resp = (List<Object[]>) query.list();
            tx.commit();
        } catch (HibernateException he) {
            log.info(he.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } finally {
            if (sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    public List obtenerClientes(String estados) {
        List resp = null;
        iniciaOperacion();
        try {
            
            // Se busca el dato mas reciente de la unidad
            String sql = "select * from clientes where estado in (:estados) ";
            SQLQuery query = sesion.createSQLQuery(sql);
            query.setParameterList("estados", estados.split(","));
            resp = (List<Object[]>) query.list();
            tx.commit();
        } catch (HibernateException he) {
            log.info(he.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } finally {
            if (sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }
    
    public List obtenerTareas(int usuario) {
        List resp = null;
        iniciaOperacion();
        try {
            // Se busca el dato mas reciente de la unidad
            String sql = "select ta.id, ta.titulo, ta.descripcion, ta.fechaentrega from usuarios us inner join tareas ta on us.id = ta.usuario where us.id=:id";
            SQLQuery query = sesion.createSQLQuery(sql);
            query.setParameter("id", usuario);
            resp = (List<Object[]>) query.list();
            tx.commit();
        } catch (HibernateException he) {
            log.info(he.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } finally {
            if (sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }
    
    public Object obtenerUsuario(int id) {
        Object resp = null;
        iniciaOperacion();
        try {
            // Se busca el dato mas reciente de la unidad
            String sql = "select "
                    + "		id, "
                    + "		username,"
                    + "		nombre, "
                    + "		apellidos,"
                    + "		pwd,"
                    + "		status,"
                    + "		email,"
                    + "		role "
                    + "from usuarios "
                    + "where id = :id";
            SQLQuery query = sesion.createSQLQuery(sql);
            query.setParameter("id", id);
            resp = query.uniqueResult();
            tx.commit();
        } catch (HibernateException he) {
            log.info(he.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } finally {
            if (sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    public Object obtenerUsuarioPorUsernamePassword(String username, String password) {
        Object resp = null;
        iniciaOperacion();
        try {
            // Se busca el dato mas reciente de la unidad
            String sql = "select "
                    + "		id, "
                    + "		username,"
                    + "		nombre, "
                    + "		apellidos,"
                    + "         pwd,"
                    + "		status,"
                    + "		email,"
                    + "		role "
                    + "from usuarios "
                    + "where username = :username and pwd = :password and status = 1";
            SQLQuery query = sesion.createSQLQuery(sql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            resp = query.uniqueResult();
            tx.commit();
        } catch (HibernateException he) {
            log.info(he.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } finally {
            if (sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }

    public Object crearTarea(Tarea tarea) {
        Object resp = null;
        iniciaOperacion();
        try {
            // Se busca el dato mas reciente de la unidad
            String sql = "INSERT INTO tareas(titulo,descripcion,fechaentrega,usuario) VALUES (:titulo,:descripcion,:fechaentrega,:usuario);";
            SQLQuery query = sesion.createSQLQuery(sql);
            query.setParameter("titulo", tarea.getTitulo());
            query.setParameter("descripcion", tarea.getDescripcion());
            query.setParameter("fechaentrega", tarea.getFechaentrega());
            query.setParameter("usuario", tarea.getUsuario());
            resp = query.executeUpdate();
            tx.commit();
        } catch (HibernateException he) {
            log.info(he.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            resp = null;
        } finally {
            if (sesion.isOpen()) {
                sesion.close();
            }
        }
        return resp;
    }
    
}
