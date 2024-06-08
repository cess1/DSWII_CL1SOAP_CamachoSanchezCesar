package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumerosParesService {

    public List<Integer> obtenerNumerosPares() {
        List<Integer> numerosPares = new ArrayList<>();

        for (int i = 2; i <= 100; i += 2) {
            numerosPares.add(i);
        }
        return numerosPares;
    }
}
