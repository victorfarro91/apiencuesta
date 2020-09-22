package aws.mitocode.spring.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import aws.mitocode.spring.dao.IEncuestaDao;
import aws.mitocode.spring.model.Encuesta;
import aws.mitocode.spring.service.IEncuestaService;

@Service
public class EncuestaServiceImpl implements IEncuestaService {

	@Autowired
	private IEncuestaDao encuestaDao;

	@Override
	public void guardarDatos(Encuesta encuesta) {
		this.encuestaDao.save(encuesta);
	}

	@Override
	public List<Encuesta> obtenerTodos() {
		return this.encuestaDao.findAll();
	}

	@Override
	public Page<Encuesta> obtenerDatosPaginados(Pageable pageable) {
		return encuestaDao.obtenerEncuesta(pageable);
	}

}
