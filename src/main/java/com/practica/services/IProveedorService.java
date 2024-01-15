package com.practica.services;
import java.util.List;

import com.practica.entity.Proveedor;

public interface IProveedorService {
	public List<Proveedor> findAll();
	public Proveedor save (Proveedor proveedor);
	public Proveedor findById(Long id);
	public void delete(Long id);
}
