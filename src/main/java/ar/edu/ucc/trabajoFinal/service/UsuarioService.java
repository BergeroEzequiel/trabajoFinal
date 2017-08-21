package ar.edu.ucc.trabajoFinal.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IUsuarioDao;
import ar.edu.ucc.trabajoFinal.dao.UsuarioDao;
import ar.edu.ucc.trabajoFinal.dto.UsuarioDto;
import ar.edu.ucc.trabajoFinal.model.Usuario;

@Service
@Transactional
public class UsuarioService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Usuario, Long> usuarioDao;

	IUsuarioDao usuarioDaoParticular;

	@PostConstruct
	public void init() {
		usuarioDaoParticular = (UsuarioDao) usuarioDao;
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public UsuarioDto getUsuario(Long id) {

		log.info("Cargando usuario: " + id);

		Usuario usuario = usuarioDaoParticular.load(id);

		UsuarioDto usuarioDto = new UsuarioDto();

		usuarioDto.setApellido(usuario.getApellido());
		usuarioDto.setEmail(usuario.getEmail());
		// usuarioDto.setEstadoSistema(usuario.getEstadoSistema());
		usuarioDto.setId(usuario.getId());
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setNombreCuenta(usuario.getNombreCuenta());
		usuarioDto.setRol(usuario.getRol().getDescripcion());
		usuarioDto.setUltimaConeccion(usuario.getUltimaConeccion());

		return usuarioDto;
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<UsuarioDto> getUsuarios() {

		log.info("Buscando todos los usuarios");

		List<Usuario> usuarios = usuarioDaoParticular.getAll();

		List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>();

		UsuarioDto usuarioDto;

		for (Usuario usuario : usuarios) {
			usuarioDto = new UsuarioDto();
			usuarioDto.setApellido(usuario.getApellido());
			usuarioDto.setEmail(usuario.getEmail());
			usuarioDto.setEstadoSistema(usuario.getEstadoSistema());
			usuarioDto.setId(usuario.getId());
			usuarioDto.setNombre(usuario.getNombre());
			usuarioDto.setNombreCuenta(usuario.getNombreCuenta());
			usuarioDto.setRol(usuario.getRol().getDescripcion());
			usuarioDto.setUltimaConeccion(usuario.getUltimaConeccion());

			usuariosDto.add(usuarioDto);

		}
		return usuariosDto;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public UsuarioDto grabarUsuario(UsuarioDto usuarioDto) {

		log.info("Guardando: " + usuarioDto.toString());

		
		Usuario usuario = new Usuario();
		
		usuario.setApellido(usuarioDto.getApellido());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setNombreCuenta(usuarioDto.getNombreCuenta());
		//usuario.setPassword(usuarioDto.);
		//usuario.setRol(usuarioDto.getRol());
		//-----------------falta estadoSistema, password y ultimaConexion.--------------
		
		usuarioDaoParticular.saveOrUpdate(usuario);
		usuarioDto.setId(usuario.getId());
		usuarioDto.setEstadoSistema(usuario.getEstadoSistema());
		usuarioDto.setUltimaConeccion(usuario.getUltimaConeccion());

		return usuarioDto;
	}

}
