package com.example.arqui_hexagonal.domain.usecase;

import com.example.arqui_hexagonal.domain.api.IPhotoServicePort;
import com.example.arqui_hexagonal.domain.model.Photo;
import com.example.arqui_hexagonal.domain.spi.IPhotoPersistencesPort;

import java.util.List;

public class PhotoUseCase implements IPhotoServicePort {

    private final IPhotoPersistencesPort photoPersistencesPort;

    public PhotoUseCase(IPhotoPersistencesPort photoPersistencesPort) {
        this.photoPersistencesPort = photoPersistencesPort;
    }


    @Override
    public Photo savePhoto(Photo photo) {
        return photoPersistencesPort.savePhoto(photo);
    }

    @Override
    public List<Photo> getAllPhoto() {
        return photoPersistencesPort.getAllPhoto();
    }

    @Override
    public Photo getPhoto(String PhotoId) {
        return photoPersistencesPort.getPhoto(PhotoId);
    }

    @Override
    public void updatePhoto(Photo photo) {
        photoPersistencesPort.updatePhoto(photo);
    }

    @Override
    public void deletePhoto(Long PhotoId) {
        photoPersistencesPort.deletePhoto(PhotoId);
    }
}
