package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service.DescuentoService;
import pe.edu.cibertec.ws.objects.CalcularDescuentoRequest;
import pe.edu.cibertec.ws.objects.CalcularDescuentoResponse;

@Endpoint
public class DescuentoEndpoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    private final DescuentoService descuentoService;

    @Autowired
    public DescuentoEndpoint(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calcularDescuentoRequest")
    @ResponsePayload
    public CalcularDescuentoResponse calcularDescuento(@RequestPayload CalcularDescuentoRequest request) {
        CalcularDescuentoResponse response = new CalcularDescuentoResponse();
        double valorTotal = descuentoService.calcularDescuento(request.getCantidad(), request.getPrecio());
        response.setValorTotal(valorTotal);
        return response;
    }
}
