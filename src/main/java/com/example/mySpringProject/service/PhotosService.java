package com.example.mySpringProject.service;

import com.example.mySpringProject.model.Photo;
import com.example.mySpringProject.repository.PhotosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
@Service
public class PhotosService {
    @Autowired

    PhotosRepository photosRepository;



    // Retrieve all photos from the repository
    public Iterable<Photo> get() {
        return photosRepository.findAll();
    }

    // Retrieve a specific photo by ID
    public Photo get(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    // Remove a photo by ID
    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    // Save a new photo
    public Photo save(String fileName, String contentType, byte[] data) {
       Photo photo =new Photo();
       photo.setContentType(contentType);
       photo.setFileName(fileName);
       photo.setData(data);
       photosRepository.save(photo);
        return photo;
    }
}
