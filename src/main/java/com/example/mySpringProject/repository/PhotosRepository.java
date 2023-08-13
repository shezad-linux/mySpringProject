package com.example.mySpringProject.repository;


import com.example.mySpringProject.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<Photo, Integer> {
}