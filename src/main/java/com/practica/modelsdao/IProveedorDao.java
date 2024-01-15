package com.practica.modelsdao;

import org.springframework.data.repository.CrudRepository;

import com.practica.entity.Proveedor;

public interface IProveedorDao extends CrudRepository<Proveedor, Long> {

}
