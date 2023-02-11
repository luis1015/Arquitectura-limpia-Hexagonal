package com.example.arqui_hexagonal.domain.model;


public class Pokemon {
    private Long id;
    private Long number;
    private Long typeId;
    private String name;
    private String photoId; //En mongo se manejan como string las llaves

    public Pokemon(Long id, Long number, Long typeId, String name, String photoId) {
        this.id = id;
        this.number = number;
        this.typeId = typeId;
        this.name = name;
        this.photoId = photoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
}
