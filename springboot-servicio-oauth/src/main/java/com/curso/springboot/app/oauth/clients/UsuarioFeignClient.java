package com.curso.springboot.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.springboot.app.usercommons.models.entity.Usuario;

@FeignClient("servicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping(value = "/usuarios/search/find-username")
	public Usuario findByUsername(@RequestParam String username);

	@PutMapping("/usuarios/{id}")
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id);

}
