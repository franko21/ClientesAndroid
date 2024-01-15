package com.practica.services;

import java.util.List;

import com.practica.entity.Articulos;

public interface IArticuloService {
	
	public List<Articulos> findAll();
	
	public Articulos save(Articulos articulos);
	
	public Articulos findById(Long id_articulo);
	
	public void delete(Long id_articulo);
	
}
