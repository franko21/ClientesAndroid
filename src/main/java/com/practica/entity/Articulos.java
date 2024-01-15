package com.practica.entity;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="articulos")
public class Articulos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_articulo;
	
	
	@Column(nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Long id_proveedor;
	
	private String nombre;
	private Double precio;
	private String categoria;
	private Long numeroVendido;
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Long getId_articulo() {
		return id_articulo;
	}
	public void setId_articulo(Long id_articulo) {
		this.id_articulo = id_articulo;
	}
	public Long getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedores(Long id_proveedores) {
		this.id_proveedor = id_proveedores;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Long getNumeroVendido() {
		return numeroVendido;
	}
	public void setNumeroVendido(Long numeroVendido) {
		this.numeroVendido = numeroVendido;
	}
	
	
	
	
	
}
