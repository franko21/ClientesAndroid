package com.practica.modelsdao;

import org.springframework.data.repository.CrudRepository;

import com.practica.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long> {
	 
	

}
