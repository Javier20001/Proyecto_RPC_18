package com.kafka.provider.dtos;

import com.kafka.provider.entities.ProductProvider;
import jakarta.persistence.Column;

public class ProductProviderDTO {
    private String codigo;

    private String color;

    private String talle;

    private int stock;

    public ProductProviderDTO(String codigo, String color, String talle, int stock) {
        this.codigo = codigo;
        this.color = color;
        this.talle = talle;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public ProductProvider toProductProvider(){
        ProductProvider pp = new ProductProvider();
        pp.setCodigo(this.getCodigo());
        pp.setColor(this.getColor());
        pp.setTalle(this.getTalle());
        pp.setStock(this.getStock());
        return pp;
    }
}
