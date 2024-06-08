package pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.DSWII_CL1SOAP_CamachoSanchezCesar.api_soap.configuration.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
