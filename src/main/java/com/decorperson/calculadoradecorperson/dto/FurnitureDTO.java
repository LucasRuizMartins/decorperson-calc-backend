package com.decorperson.calculadoradecorperson.dto;

import com.decorperson.calculadoradecorperson.entities.Furniture;
import com.decorperson.calculadoradecorperson.entities.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Objects;


public class FurnitureDTO {


    private Long id;

    @Size(min = 5, max = 120, message = "nome precisa ter entre 5 e 120 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @Positive(message = "O preço deve ser positivo")
    private Integer length;
    @Positive(message = "O preço deve ser positivo")
    private Integer height;
    @Positive(message = "O preço deve ser positivo")
    private Integer width;

    @Positive(message = "O preço deve ser positivo")
    private String imgUrl;


    public FurnitureDTO(Furniture entity) {
        id = entity.getId();
        this.name = entity.getName();
        this.length = entity.getLength();
        this.height = entity.getHeight();
        this.width = entity.getWidth();
        this.imgUrl = entity.getImgUrl();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FurnitureDTO that = (FurnitureDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}


