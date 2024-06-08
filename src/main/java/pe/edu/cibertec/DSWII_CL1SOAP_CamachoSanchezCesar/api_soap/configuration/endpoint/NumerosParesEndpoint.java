package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.ws.objects.ObtenerNumerosParesResponse;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class NumerosParesEndpoint {

    private static final String NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerNumerosParesRequest")
    @ResponsePayload
    public ObtenerNumerosParesResponse obtenerNumerosPares() {
        ObtenerNumerosParesResponse response = new ObtenerNumerosParesResponse();
        List<Integer> numerosPares = obtenerNumerosParesLogic();
        response.setNumerosPares(numerosPares);
        return response;
    }

    private List<Integer> obtenerNumerosParesLogic() {
        List<Integer> numerosPares = new ArrayList<>();
        // Lógica para obtener números pares
        for (int i = 2; i <= 100; i += 2) {
            numerosPares.add(i);
        }
        return numerosPares;
    }
}