package com.decorperson.calculadoradecorperson.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_furnitures")
public class Furniture{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;
    private Integer length;
    private Integer height;
    private Integer width;
    private String imgUrl;


    public Furniture(Long id, String name, Integer length, Integer height, Integer width, String imgUrl) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.height = height;
        this.width = width;
        this.imgUrl = imgUrl;
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
        Furniture furniture = (Furniture) o;
        return Objects.equals(id, furniture.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
