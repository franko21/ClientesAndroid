package com.practica.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public interface ImageService {
	void saveImage(MultipartFile file) throws IOException;
}
