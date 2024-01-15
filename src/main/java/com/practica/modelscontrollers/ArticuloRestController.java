package com.practica.modelscontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.practica.entity.Articulos;
import com.practica.services.IArticuloService;



@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ArticuloRestController {

	@Autowired
	private IArticuloService articuloService;

	//listar clientes disponibles
	@GetMapping("/articulos")
	public List<Articulos> index(){
		return articuloService.findAll();
	}
	
	//buscar un cliente por id
	@GetMapping("/articulos/{id_articulo}")
		public Articulos show (@PathVariable Long id_articulo){
			return articuloService.findById(id_articulo);
	}
	
	//insertar un cliente
	@PostMapping("/articulos")
	@ResponseStatus(HttpStatus.CREATED)
	public Articulos create (@RequestBody Articulos articulo){
		return articuloService.save(articulo);
	}
	
	//editar un cliente
	@PutMapping("/articulos/{id_articulo}")
	public Articulos update (@RequestBody Articulos articulo, @PathVariable Long id_articulo) {
		Articulos articuloActual = articuloService.findById(id_articulo);
		articuloActual.setNombre(articulo.getNombre());
		articuloActual.setCategoria(articulo.getCategoria());
		articuloActual.setPrecio(articulo.getPrecio());
		return articuloService.save(articuloActual);
	}
	
	//eliminar un cliente
	@DeleteMapping("/articulos/{id_articulo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id_articulo) {
		articuloService.delete(id_articulo);
	}
	
	
}
