package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service;

import pe.edu.cibertec.ws.objects.Autorws;

import java.util.List;

public interface IAutorService {
    List<Autorws> listarAutores();

    Autorws obtenerAutorPorId(int id);

    Autorws registrarActualizarAutor(Autorws autorws);
}
