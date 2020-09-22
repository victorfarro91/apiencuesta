package aws.mitocode.spring.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;

import aws.mitocode.spring.model.Encuesta;

public interface IEncuestaService {
	
	List<Encuesta> obtenerTodos();
	Page<Encuesta> obtenerDatosPaginados(Pageable pageable);
	void guardarDatos(Encuesta encuesta);
}
