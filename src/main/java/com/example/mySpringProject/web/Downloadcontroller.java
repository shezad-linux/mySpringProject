package com.example.mySpringProject.web;

import com.example.mySpringProject.model.Photo;
import com.example.mySpringProject.service.PhotosService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Downloadcontroller {
    private final PhotosService photosService;

    public Downloadcontroller(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        Photo photo= photosService.get(id);
        if(photo==null) throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        byte[] data = photo.getData();

        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.
                builder("attachment").
                filename(photo.getFileName())
                .build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);

    }
}
