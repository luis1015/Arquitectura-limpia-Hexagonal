package com.example.arqui_hexagonal.domain.model;

public class Type {
    private Long id;
    private String firtType;
    private String secondType;

    public Type(Long id, String firtType, String secondType) {
        this.id = id;
        this.firtType = firtType;
        this.secondType = secondType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtType() {
        return firtType;
    }

    public void setFirtType(String firtType) {
        this.firtType = firtType;
    }

    public String getSecondType() {
        return secondType;
    }

    public void setSecondType(String secondType) {
        this.secondType = secondType;
    }
}
