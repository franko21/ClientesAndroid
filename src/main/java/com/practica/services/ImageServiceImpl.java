package com.practica.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practica.entity.ImageEntity;
import com.practica.modelsdao.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{

	private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void saveImage(MultipartFile file) throws IOException {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageName(file.getOriginalFilename());
        imageEntity.setImageData(file.getBytes());
        imageRepository.save(imageEntity);
    }

}
