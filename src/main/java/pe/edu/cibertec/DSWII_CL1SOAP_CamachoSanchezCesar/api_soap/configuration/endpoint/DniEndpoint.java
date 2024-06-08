package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service.DniService;
import pe.edu.cibertec.ws.objects.NecesitaDNIRequest;
import pe.edu.cibertec.ws.objects.NecesitaDNIResponse;

@Endpoint
public class DniEndpoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    private final DniService dniService;

    @Autowired
    public DniEndpoint(DniService dniService) {
        this.dniService = dniService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "necesitaDNIRequest")
    @ResponsePayload
    public NecesitaDNIResponse verificarNecesidadDNI(@RequestPayload NecesitaDNIRequest request) {
        NecesitaDNIResponse response = new NecesitaDNIResponse();
        response.setNecesitaDNI(dniService.verificarNecesidadDNI(request.getAñoNacimiento()));
        return response;
    }
}
