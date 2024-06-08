package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service;

import org.springframework.stereotype.Service;

@Service
public class DniService {
    public boolean verificarNecesidadDNI(int añoNacimiento) {
        int añoActual = java.time.LocalDate.now().getYear();
        return (añoActual - añoNacimiento) >= 18;
    }
}
