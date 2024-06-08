package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.model.Autor;
import pe.edu.cibertec.ws.objects.Autorws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class AutorConvert {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Autor convertAutorwsToAutor(Autorws autorws) {
        Autor autor = new Autor();
        autor.setIdAutor(autorws.getIdAutor());
        autor.setNomAutor(autorws.getNomAutor());
        autor.setApeAutor(autorws.getApeAutor());
        try {
            autor.setFechNacAutor(dateFormat.parse(autorws.getFechNacAutor()));
        } catch (ParseException e) {
            e.printStackTrace(); // Maneja la excepción de acuerdo a tus necesidades
        }
        return autor;
    }

    public List<Autor> convertAutorwsToAutor(List<Autorws> autorwsList) {
        List<Autor> autorList = new ArrayList<>();
        autorwsList.forEach(autorws -> autorList.add(convertAutorwsToAutor(autorws)));
        return autorList;
    }

    public Autorws convertAutorToAutorws(Autor autor) {
        Autorws autorws = new Autorws();
        autorws.setIdAutor(autor.getIdAutor());
        autorws.setNomAutor(autor.getNomAutor());
        autorws.setApeAutor(autor.getApeAutor());
        autorws.setFechNacAutor(dateFormat.format(autor.getFechNacAutor()));
        return autorws;
    }

    public List<Autorws> convertAutorToAutorws(List<Autor> autorList) {
        List<Autorws> autorwsList = new ArrayList<>();
        autorList.forEach(autor -> autorwsList.add(convertAutorToAutorws(autor)));
        return autorwsList;
    }
}
