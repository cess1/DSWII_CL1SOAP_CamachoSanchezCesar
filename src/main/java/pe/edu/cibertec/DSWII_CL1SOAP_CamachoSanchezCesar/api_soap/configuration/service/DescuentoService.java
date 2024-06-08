package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service;

import org.springframework.stereotype.Service;

@Service
public class DescuentoService {

    public double calcularDescuento(double cantidad, double precio) {

        double descuento = 0.0;
        if (cantidad > 10) {
            descuento = precio * 0.1; // 10% de descuento
        }
        double valorTotal = precio - descuento;

        return valorTotal;
    }
}
