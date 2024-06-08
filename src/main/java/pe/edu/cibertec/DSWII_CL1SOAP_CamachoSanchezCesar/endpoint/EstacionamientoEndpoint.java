package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.endpoint;

import generated.CalcularCostoEstacionamientoRequest;
import generated.CalcularCostoEstacionamientoResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.service.EstacionamientoService;

@Endpoint
public class EstacionamientoEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.org/estacionamiento";

    private final EstacionamientoService estacionamientoService;

    public EstacionamientoEndpoint(EstacionamientoService estacionamientoService) {
        this.estacionamientoService = estacionamientoService;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calcularCostoEstacionamientoRequest")
    @ResponsePayload
    public CalcularCostoEstacionamientoResponse calcularCosto(@RequestPayload CalcularCostoEstacionamientoRequest request) {
        CalcularCostoEstacionamientoResponse response = new CalcularCostoEstacionamientoResponse();
        response.setCosto(estacionamientoService.calcularCostoEstacionamiento(request.getHoras(), request.getMinutos()));
        return response;
    }
}