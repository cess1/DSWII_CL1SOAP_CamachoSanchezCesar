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
    @Bean(name = "alumno")
    public DefaultWsdl11Definition alumnoWsdl(XsdSchema alumnoSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AlumnoPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(alumnoSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema alumnoSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/notas.xsd"));
    }

    // Configuración para el servicio del DNI
    @Bean(name = "dni")
    public DefaultWsdl11Definition dniWsdl(XsdSchema dniSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DniPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(dniSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema dniSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/dni.xsd"));
    }

    // Configuración para el servicio de obtener números pares
    @Bean(name = "numerosPares")
    public DefaultWsdl11Definition numerosParesWsdl(XsdSchema numerosParesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("NumerosParesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(numerosParesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema numerosParesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/numerosPares.xsd"));
    }

    // Configuración del servlet de Spring WS
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
    // Configuración para el servicio de almacenamiento
    @Bean(name = "descuento")
    public DefaultWsdl11Definition descuentoWsdl(XsdSchema almacenSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AlmacenPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://cibertec.edu.pe/objects");
        wsdl11Definition.setSchema(almacenSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema almacenSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/descuento.xsd"));
    }

    // Configuración para el servicio de Autor
    @Bean(name = "autor")
    public DefaultWsdl11Definition autorWsdl(XsdSchema autorSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AutorPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(autorSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema autorSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/autor.xsd"));
    }


}
