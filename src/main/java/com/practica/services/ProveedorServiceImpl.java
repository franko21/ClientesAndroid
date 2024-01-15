package com.practica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.entity.Proveedor;
import com.practica.modelsdao.IProveedorDao;

@Service
public class ProveedorServiceImpl  implements IProveedorService{
     
	@Autowired
    private IProveedorDao ProveedorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Proveedor> findAll() {
		// TODO Auto-generated method stub
		return (List<Proveedor>) ProveedorDao.findAll();
	}
	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return ProveedorDao.save(proveedor);
	}
	@Override
	@Transactional(readOnly=true)
	public Proveedor findById(Long id) {
		// TODO Auto-generated method stub
		return ProveedorDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		ProveedorDao.deleteById(id);
		
	}
	

}
