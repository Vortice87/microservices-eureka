package com.cuso.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.curso.springboot.app.commos.model.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {
	
}
 