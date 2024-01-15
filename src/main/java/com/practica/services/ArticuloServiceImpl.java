package com.practica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.entity.Articulos;
import com.practica.modelsdao.IArticuloDao;

@Service
public class ArticuloServiceImpl implements IArticuloService{

	@Autowired
	private IArticuloDao articuloDao;

	@Override
	@Transactional(readOnly=true)
	public List<Articulos> findAll() {
		// TODO Auto-generated method stub
		return (List<Articulos>)articuloDao.findAll();
	}

	@Override
	@Transactional
	public Articulos save(Articulos articulos) {
		// TODO Auto-generated method stub
		return articuloDao.save(articulos);
	}

	@Override
	@Transactional(readOnly=true)
	public Articulos findById(Long id_articulo) {
		// TODO Auto-generated method stub
		return articuloDao.findById(id_articulo).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id_articulo) {
		// TODO Auto-generated method stub
		articuloDao.deleteById(id_articulo);
		
	}
	
	
	
	
}
