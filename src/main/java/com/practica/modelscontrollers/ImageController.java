package com.practica.modelscontrollers;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practica.services.ImageService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/images")
public class ImageController {
	private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public void uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        imageService.saveImage(file);
    }

}
