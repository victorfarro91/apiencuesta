package aws.mitocode.spring.controller.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aws.mitocode.spring.dto.RespuestaApi;
import aws.mitocode.spring.model.Encuesta;
import aws.mitocode.spring.service.IEncuestaService;

@RestController
@CrossOrigin
@RequestMapping("api/encuesta")
public class ApiEncuesta {

private static final Logger logger = LoggerFactory.getLogger(ApiEncuesta.class);
	
	@Autowired
	private IEncuestaService serviceEncuesta;
	
	/*@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Encuesta>> obtenerTodos(){
		try {
			return new ResponseEntity<List<Encuesta>>(
					serviceEncuesta.obtenerTodos(), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/	
	
	@PreAuthorize("hasRole('ROLE_QUIZ')")
	@PostMapping(value="registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaApi> guardar(
			@RequestBody Encuesta encuesta){
		try {
			serviceEncuesta.guardarDatos(encuesta);
			return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",""), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<RespuestaApi>(new RespuestaApi("",""), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value="listar-paginado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obtenerTodos(Pageable pageable){
		try {
			//User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return new ResponseEntity<Page<Encuesta>>(
					serviceEncuesta.obtenerDatosPaginados(pageable), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
