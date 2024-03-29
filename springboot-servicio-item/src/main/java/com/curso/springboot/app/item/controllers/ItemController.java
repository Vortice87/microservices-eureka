package com.curso.springboot.app.item.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.app.item.models.Item;
import com.curso.springboot.app.commos.model.entity.Producto;
import com.curso.springboot.app.item.models.service.ItemService;

@RefreshScope
@RestController					
public class ItemController {
	
	private final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
		
	@Autowired
	@Qualifier("serviceFeign")
	private ItemService itemService;
	
	//@Value("${configuracion.texto}")
	//private String texto;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/listar")
	public List<Item> listar(@RequestParam(name="nombre", required= false) String nombre, @RequestHeader(name="token-request", required = false) String token){
		System.out.println(nombre);
		System.out.println(token);
		return itemService.findAll();
	}
	
	//@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return cbFactory.create("items")
				.run(() -> itemService.findById(id, cantidad)/*, e -> metodoAlternativo(id, cantidad, e)*/);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad, Throwable e) {
		
		logger.info(e.getMessage());
		Item item = new Item();
		Producto producto = new Producto();
		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre(e.getMessage());
		producto.setPrecio(500.00);
		item.setProducto(producto);
		return item;
	}
	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfig(){
		Map<String, String> json = new HashMap<>();
		//json.put("texto", texto);
		if(env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("autor", env.getProperty("configuracion.autor.nombre"));
			json.put("email", env.getProperty("configuracion.autor.email"));
		}
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return itemService.save(producto);
	}
	
	@PutMapping("/modificar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto modificar(@RequestBody Producto producto, @PathVariable Long id) {
		return itemService.update(producto, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		itemService.delete(id);
	}

}
