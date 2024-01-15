package com.practica.modelscontrollers;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.practica.entity.Proveedor;
import com.practica.services.IArticuloService;
import com.practica.services.IProveedorService;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class ProveedorRestController {
	@Autowired
	private IArticuloService articuloService;
	
	@Autowired
	private IProveedorService proveedorService;
	

	
	
	
		@GetMapping("/proveedores")
		public List<Proveedor> index(){
			return proveedorService.findAll();
		}
		
		
		@GetMapping("/proveedores/{id}")
			public Proveedor show (@PathVariable Long id){
				return proveedorService.findById(id);
		}
		
		
		@PostMapping("/proveedores")
		@ResponseStatus(HttpStatus.CREATED)
		public Proveedor create (@RequestBody Proveedor proveedor){
			
			return proveedorService.save(proveedor);
		}
		
		
		@PutMapping("/proveedores/{id}")
		public Proveedor update (@RequestBody Proveedor  proveedor , @PathVariable Long id) {
			Proveedor proveedorActual = proveedorService.findById(id);
			proveedorActual.setApellido(proveedor.getApellido());
			proveedorActual.setNombre(proveedor.getNombre());
			proveedorActual.setEmail(proveedor.getEmail());
			proveedorActual.setRedSocial(proveedor.getRedSocial());
			proveedorActual.setDescripcion(proveedor.getDescripcion());
			proveedorActual.setLinkFoto(proveedor.getLinkFoto());
			return proveedorService.save(proveedorActual);
		}
		
		
		@DeleteMapping("/proveedores/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			final Long nA =(long)proveedorService.findById(id).getArticulos().size();
			for	(int i=0;i<nA;i++) {
				Long ide=proveedorService.findById(id).getArticulos().get(i).getId_articulo();
				articuloService.delete(ide);
				System.out.println(proveedorService.findById(id).getArticulos().get(i).getId_articulo());
			}
			proveedorService.delete(id);
			
			
		}
}
