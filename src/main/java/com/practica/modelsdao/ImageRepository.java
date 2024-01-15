package com.practica.modelsdao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long>{

}
