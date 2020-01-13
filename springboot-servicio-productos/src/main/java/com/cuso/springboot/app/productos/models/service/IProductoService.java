package com.cuso.springboot.app.productos.models.service;

import java.util.List;

import com.cuso.springboot.app.productos.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto findById(Long Id);
	public Producto save(Producto producto);
	public void deleteById(Long id);
	
}
