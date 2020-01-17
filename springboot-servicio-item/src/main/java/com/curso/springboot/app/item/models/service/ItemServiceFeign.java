package com.curso.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.springboot.app.item.clientes.ProductoClienteRest;
import com.curso.springboot.app.item.models.Item;
import com.curso.springboot.app.commos.model.entity.Producto;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService{
	
	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p ->
				new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return clienteFeign.modificar(producto, id);
	}

	@Override
	public void delete(Long id) {
		clienteFeign.eliminar(id);
	}

}
