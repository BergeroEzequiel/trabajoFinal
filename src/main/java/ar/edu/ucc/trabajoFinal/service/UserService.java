/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.ucc.trabajoFinal.service;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.EstadoDao;
import ar.edu.ucc.trabajoFinal.dao.IEstadoDao;
import ar.edu.ucc.trabajoFinal.dao.IUserDao;
import ar.edu.ucc.trabajoFinal.dao.UserDao;
import ar.edu.ucc.trabajoFinal.dto.UserDto;
import ar.edu.ucc.trabajoFinal.model.Estado;
import ar.edu.ucc.trabajoFinal.model.UserProfile;
import ar.edu.ucc.trabajoFinal.model.Usuario;
import ar.edu.ucc.trabajoFinal.utils.MailService;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ezequiel
 */
@Service
@Transactional
public class UserService {
    
    private static final String CARACTERES_PASSWORD ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Autowired
    DaoGenerico<Usuario, Long> usuarioDao;

    IUserDao usuarioDaoParticular;

    @Autowired
    DaoGenerico<Estado, Long> estadoDao;

    IEstadoDao estadoDaoParticular;

    @Autowired
    MailService mailService;

    @Value("${mail.username}")
    private String mailUsername;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostConstruct
    public void init() {
        usuarioDaoParticular = (UserDao) usuarioDao;
        estadoDaoParticular = (EstadoDao) estadoDao;
    }

    public Usuario findById(Long id) {
        return usuarioDaoParticular.findById(id);
    }

    public Usuario findBySso(String sso) {
        return usuarioDaoParticular.findBySSO(sso);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Usuario grabarNuevoUsuario(Usuario user) {
        if (user.getId() == null) {
            try {
                user.setEstado(estadoDaoParticular.getEstadoById(Estado.PENDIENTE));
                user.setUserProfile(null);
                usuarioDaoParticular.saveOrUpdate(user);
                String templateHtml = "<font >Bienvenido <b> " + user.getFirstName() + " " + user.getLastName() + "</b>!.<br>"
                        + "Su nombre de usuario para ingresar es: <b> " + user.getSsoId() + " </b></font><br><br>"
                        + "<font color='#c94c4c'><b> Le recordamos que su usuario está a la espera para ser aprobado por el Administrador de la aplicacion. <br>"
                        + "Hasta no ser aprobado no podrá ingresar. </b></font>";

                mailService.send(mailUsername, user.getEmail(), "Bienvenido.", templateHtml);
                this.informarNuevoUsuario(user);
                return user;
                
            } catch (Exception e) {
                throw new RuntimeException("Ups! Algo salió mal, por favor intentelo de nuevo.", e);
            }
            
            
            
        }

        throw new RuntimeException("Este método solo crea usuarios. Envie un User con id nulo por favor.");
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<Usuario> getUsuarios() throws ParseException {
        List<Usuario> usuarios = this.usuarioDaoParticular.getAll();
        return usuarios;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Usuario> getUsuariosByState(String state) {
        return usuarioDaoParticular.getUsuariosByState(state);
    }
    
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Usuario> getUsuariosByIdRol(Long idRol) {
        return usuarioDaoParticular.getUsuariosByIdRol(idRol);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Usuario actualizarPasswordUsuario(UserDto userDto) {
        if (userDto.getPassword().equals(userDto.getPasswordNuevo())) {
            throw new RuntimeException("Los password son iguales. Para cambiar "
                    + "la password debe ingresar una distinta a la anterior.");
        }
        Usuario usuario = this.usuarioDaoParticular.findBySSO(userDto.getSsoId());
        if (usuario == null) {
            throw new RuntimeException("El usuario con nombre " + userDto.getSsoId() + " no existe.");
        }
        if (usuario != null && !bCryptPasswordEncoder.matches(userDto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta. Si no recuerda su contraseña seleccione 'Recuperar password'.");
        }

            usuario.setPassword(bCryptPasswordEncoder.encode(userDto.getPasswordNuevo()));
            usuarioDaoParticular.saveOrUpdate(usuario);
            
        return usuario;
    }

    /**
     * Este método sirve para actualizar todos los datos de un usuario, MENOS la
     * PASSWORD e ID.
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Usuario actualizarUsuario(Usuario user) {
        if (user.getId() == null) {
            throw new RuntimeException("ID nulo. No se puede actualizar un usuario sin ID.");
        }

        Usuario usuarioOriginal = this.usuarioDaoParticular.findById(user.getId());
        usuarioOriginal.setEmail(user.getEmail());
        usuarioOriginal.setEstado(user.getEstado());
        usuarioOriginal.setFirstName(user.getFirstName());
        usuarioOriginal.setSsoId(user.getSsoId());
        usuarioOriginal.setUserProfile(user.getUserProfile());

        usuarioDaoParticular.saveOrUpdate(usuarioOriginal);

        return usuarioOriginal;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public void blanquearPassword(String username) {
        Usuario usuario = usuarioDaoParticular.findBySSO(username);
        String nuevaPassword = this.generarPassword(8);

        if (usuario == null) {
            throw new RuntimeException("Usuario con username " + username + " NO ENCONTRADO.");
        }

        try {
            usuario.setPassword(bCryptPasswordEncoder.encode(nuevaPassword));
            usuarioDaoParticular.saveOrUpdate(usuario);
            String templateHtml = "<font >Estimado <b> " + username + "</b>"
                    + ", su nueva password es: <b> " + nuevaPassword + "</b></font><br><br>"
                    + "<font color='#c94c4c'><b> Se recomienda cambiar esta password por una propia. </b></font>";

            mailService.send(mailUsername, usuario.getEmail(), "Cambio de password.", templateHtml);

        } catch (Exception e) {
            throw new RuntimeException("Ups! Algo salió mal, por favor intentelo de nuevo.", e);
        }

    }

    private String generarPassword(int cantidadCaracteres) {
        String password = RandomStringUtils.random(cantidadCaracteres, CARACTERES_PASSWORD);
        return password;
    }
    
    /**
     * Recibe un usuario y le avisa a TODOS los ADMINISTRADORES via email 
     * sobre el nuevo usuario para que puedan revisar y aceptarlo o rechazarlo.
     */
    private void informarNuevoUsuario(Usuario user){
        List<Usuario> usuariosAdministradores = this.getUsuariosByIdRol(UserProfile.ID_ADMINISTRADOR);
        if(usuariosAdministradores != null){
            String templateHtml = "<font >Un nuevo usuario se ha creado en la aplicación. Su username es <b> " + user.getSsoId() + "</b>"
                    + " y requiere de la autorización de un ADMINISTRADOR. </font><br><br>"
                    + "<font color='#c94c4c'><b> Por favor diríjase a la pantalla de administración de usuarios a la brevedad.</b></font>";
            for (Usuario usuarioAdministrador : usuariosAdministradores) {
                try {
                    mailService.send(mailUsername, usuarioAdministrador.getEmail(), "Un nuevo usuario requiere aprobación.", templateHtml);
                } catch (MessagingException ex) {
                    Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, "No se pudo enviar el mail a " + usuarioAdministrador.getEmail(), ex);
                }
            }
        }
        
    }
}
