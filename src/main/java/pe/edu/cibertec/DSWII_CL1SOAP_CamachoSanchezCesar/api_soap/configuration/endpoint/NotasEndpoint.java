package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service.NotasService;
import pe.edu.cibertec.ws.objects.CalcularPromedioNotasRequest;
import pe.edu.cibertec.ws.objects.CalcularPromedioNotasResponse;

@Endpoint
public class NotasEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.org/notas";

    private final NotasService notasService;

    @Autowired
    public NotasEndpoint(NotasService notasService) {
        this.notasService = notasService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calcularPromedioNotasRequest")
    @ResponsePayload
    public CalcularPromedioNotasResponse calcularPromedioNotas(@RequestPayload CalcularPromedioNotasRequest request) {
        CalcularPromedioNotasResponse response = new CalcularPromedioNotasResponse();
        double promedio = notasService.calcularPromedio(
                request.getNota1(),
                request.getNota2(),
                request.getNota3(),
                request.getNota4()
        );
        response.setPromedio(promedio);
        return response;
    }
}
