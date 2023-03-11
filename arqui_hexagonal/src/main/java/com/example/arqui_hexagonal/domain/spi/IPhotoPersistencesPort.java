package com.example.arqui_hexagonal.domain.spi;

import com.example.arqui_hexagonal.domain.model.Photo;

import java.util.List;

public interface IPhotoPersistencesPort {

    Photo savePhoto(Photo photo);

    List<Photo> getAllPhoto();

    Photo getPhoto(String PhotoId);

    void updatePhoto(Photo photo);

    void deletePhoto(String photoId);
}
