package es.altair.dao;

import es.altair.bean.Usuarios;

public interface UsuarioDAO {

	Usuarios comprobarUsuario(String login, String password);

	int insertar(Usuarios usu);

	boolean validarEmail(Usuarios usu);

}
