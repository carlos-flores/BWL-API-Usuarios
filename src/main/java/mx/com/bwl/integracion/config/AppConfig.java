package mx.com.bwl.integracion.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.wordnik.swagger.jaxrs.config.BeanConfig;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import java.util.Arrays;
import javax.ws.rs.ext.RuntimeDelegate;
import mx.com.bwl.integracion.rest_service.ClientesRestService;
import mx.com.bwl.integracion.rest_service.UsuariosRestService;
import mx.com.bwl.integracion.rs.JaxRsApiApplication;
import mx.com.bwl.integracion.service.ClientesService;
import mx.com.bwl.integracion.service.UsuariosService;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    public static final String SERVER_PORT = "server.port";
    public static final String SERVER_HOST = "server.host";
    public static final String CONTEXT_PATH = "context.path";

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer() {
        JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(jaxRsApiApplication(), JAXRSServerFactoryBean.class);
//        factory.setServiceBeans(Arrays.< Object>asList(usuarioRestService(), viajeRestService(), rutasRestService(), apiListingResourceJson()));
        factory.setServiceBeans(Arrays.< Object>asList(usuarioRestService(), clientesRestService(), apiListingResourceJson()));
        factory.setAddress(factory.getAddress());
        factory.setProviders(Arrays.< Object>asList(jsonProvider(), resourceListingProvider(), apiDeclarationProvider()));
        return factory.create();
    }

    @Bean
    @Autowired
    public BeanConfig swaggerConfig(Environment environment) {
        final BeanConfig config = new BeanConfig();

        config.setVersion("1.0.0");
        config.setScan(true);
        config.setResourcePackage("");
        config.setBasePath(
                String.format("http://%s:%s/%s%s",
                environment.getProperty(SERVER_HOST),
                environment.getProperty(SERVER_PORT),
                environment.getProperty(CONTEXT_PATH),
                jaxRsServer().getEndpoint().getEndpointInfo().getAddress()));

        return config;
    }

    @Bean
    public ApiDeclarationProvider apiDeclarationProvider() {
        return new ApiDeclarationProvider();
    }

    @Bean
    public ApiListingResourceJSON apiListingResourceJson() {
        return new ApiListingResourceJSON();
    }

    @Bean
    public ResourceListingProvider resourceListingProvider() {
        return new ResourceListingProvider();
    }

    @Bean
    public JaxRsApiApplication jaxRsApiApplication() {
        return new JaxRsApiApplication();
    }

    @Bean
    public UsuariosRestService usuarioRestService() {
        return new UsuariosRestService();
    }

    @Bean
    public UsuariosService usuarioService() {
        return new UsuariosService();
    }
    
    @Bean
    public ClientesRestService clientesRestService() {
        return new ClientesRestService();
    }

    @Bean
    public ClientesService clientesService() {
        return new ClientesService();
    }
        
    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }
}
