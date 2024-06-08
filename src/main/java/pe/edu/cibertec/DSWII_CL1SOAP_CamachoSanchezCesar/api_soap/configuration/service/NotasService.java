package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service;

import org.springframework.stereotype.Service;

@Service
public class NotasService {
    public double calcularPromedio(double nota1, double nota2, double nota3, double nota4) {
        // Eliminar la nota más baja
        double minNota = Math.min(Math.min(nota1, nota2), Math.min(nota3, nota4));
        double promedio = ((nota1 + nota2 + nota3 + nota4 - minNota) / 3) * 0.5;
        return promedio;
    }
}
