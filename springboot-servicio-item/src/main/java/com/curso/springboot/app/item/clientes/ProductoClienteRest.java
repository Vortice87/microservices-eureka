package com.curso.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curso.springboot.app.commos.model.entity.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
	
	@GetMapping(value="/listar")
	public List<Producto> listar();
	
	@GetMapping(value="/ver/{id}")
	public Producto detalle(@PathVariable Long id);
	
	@PostMapping(value="/crear")
	public Producto crear(@RequestBody Producto producto);
	
	@PutMapping(value="/modificar/{id}")
	public Producto modificar(@RequestBody Producto producto, @PathVariable Long id);
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar(@PathVariable Long id);
	
	
}
