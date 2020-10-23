package com.curso.springboot.app.oauth.services;

import com.curso.springboot.app.usercommons.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);

}
