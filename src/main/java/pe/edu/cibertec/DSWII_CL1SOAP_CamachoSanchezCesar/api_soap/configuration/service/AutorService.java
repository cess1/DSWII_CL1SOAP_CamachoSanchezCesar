package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.convert.AutorConvert;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.model.Autor;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.repository.AutorRepository;
import pe.edu.cibertec.ws.objects.Autorws;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AutorService implements IAutorService {

    private AutorRepository autorRepository;
    private AutorConvert autorConvert;

    @Override
    public List<Autorws> listarAutores() {
        return autorConvert.convertAutorToAutorws(autorRepository.findAll());
    }

    @Override
    public Autorws obtenerAutorPorId(int id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);
        return autorOptional.map(autor -> autorConvert.convertAutorToAutorws(autor))
                .orElse(null);
    }

    @Override
    public Autorws registrarActualizarAutor(Autorws autorws) {
        Autor autor = autorRepository.save(autorConvert.convertAutorwsToAutor(autorws));
        return autorConvert.convertAutorToAutorws(autor);
    }
}