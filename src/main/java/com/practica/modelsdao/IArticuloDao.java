package com.practica.modelsdao;

import org.springframework.data.repository.CrudRepository;

import com.practica.entity.Articulos;

public interface IArticuloDao extends CrudRepository<Articulos,Long>{
	
}
