package mx.com.bwl.integracion;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import mx.com.bwl.integracion.config.AppConfig;
import mx.com.tecnomotum.utils.ManejadorPropiedades;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.eclipse.jetty.util.resource.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Ejemplo de WebService que tiene embebido jetty Utiliza Swagger para generar la documentación
 *
 * @author carlos
 */
public class Starter {

    //private static final int SERVER_PORT = 8088;
    //private static final String CONTEXT_PATH = "rest";

    public static void main(final String[] args) throws Exception {
        Resource.setDefaultUseCaches(false);
        Integer SERVER_PORT = Integer.parseInt(ManejadorPropiedades.leerPropiedad("app_cfg.properties", "app.port"));
        String SERVER_HOST = ManejadorPropiedades.leerPropiedad("app_cfg.properties", "app.host");
        String CONTEXT_PATH = ManejadorPropiedades.leerPropiedad("app_cfg.properties", "app.context_path");
        
        final Server server = new Server(SERVER_PORT);
        System.setProperty(AppConfig.SERVER_PORT, SERVER_PORT.toString());
        System.setProperty(AppConfig.SERVER_HOST, SERVER_HOST);
        System.setProperty(AppConfig.CONTEXT_PATH, CONTEXT_PATH);
        

        // Configuring Apache CXF servlet and Spring listener  
        final ServletHolder servletHolder = new ServletHolder(new CXFServlet());
        final ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(servletHolder, "/" + CONTEXT_PATH + "/*");
        context.addEventListener(new ContextLoaderListener());
        context.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        context.setInitParameter("contextConfigLocation", AppConfig.class.getName());
        
        FilterHolder filterHolder = context.addFilter(CrossOriginFilter.class,"/*",EnumSet.allOf(DispatcherType.class));
        filterHolder.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM,"*");
        filterHolder.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM,"Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filterHolder.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM,"GET,PUT,POST,DELETE,OPTIONS");
        filterHolder.setInitParameter(CrossOriginFilter.PREFLIGHT_MAX_AGE_PARAM,"5184000");
        filterHolder.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM,"true");


        // Configuring Swagger as static web resource
        final ServletHolder swaggerHolder = new ServletHolder(new DefaultServlet());
        final ServletContextHandler swagger = new ServletContextHandler();
        swagger.setContextPath("/swagger");
        swagger.addServlet(swaggerHolder, "/*");
        swagger.setResourceBase(new ClassPathResource("/webapp").getURI().toString());

        final HandlerList handlers = new HandlerList();
        handlers.addHandler(swagger);
        handlers.addHandler(context);

        server.setHandler(handlers);
        server.start();
        server.join();
    }
}
