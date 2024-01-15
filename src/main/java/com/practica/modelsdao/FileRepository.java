package com.practica.modelsdao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity,Long>{

}
