package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    // Configuración para el servicio de estacionamiento
    @Bean(name = "estacionamiento")
    public DefaultWsdl11Definition estacionamientoWsdl(XsdSchema estacionamientoSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EstacionamientoPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(estacionamientoSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema estacionamientoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/estacionamiento.xsd"));
    }

    // Configuración para el servicio del alumno
    @Bean(name = "alumno") // Cambiado de "alumno" a "alumno"
    public DefaultWsdl11Definition alumnoWsdl(XsdSchema alumnoSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AlumnoPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(alumnoSchema);
        return wsdl11Definition;
    }

    @Bean // Cambiado de "alumnoSchema" a "notasSchema"
    public XsdSchema alumnoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/notas.xsd"));
    }


    // Configuración del servlet de Spring WS
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
}
