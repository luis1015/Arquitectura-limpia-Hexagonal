package com.example.arqui_hexagonal.application.dto;

import com.example.arqui_hexagonal.domain.model.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokedexResponse {
    private Long number;
    private String name;
    private TypeDto types;
    private String photo;
}
