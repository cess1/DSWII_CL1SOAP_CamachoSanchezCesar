package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.service;

import org.springframework.stereotype.Service;

@Service
public class EstacionamientoService {
    public double calcularCostoEstacionamiento(int horas, int minutos) {
        double costoPorHora = 1.5;
        int totalMinutos = horas * 60 + minutos;
        int totalHoras = (totalMinutos + 59) / 60; // Redondear hacia arriba
        return totalHoras * costoPorHora;
    }
}
