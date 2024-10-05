package com.kafka.provider.dtos;

import com.kafka.provider.entities.ProductProvider;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductProviderDTO {

    private int id;
    private String codigo;
    private String color;
    private String talle;
    private int stock;
    private String foto;

    public ProductProvider toProductProvider(){
        ProductProvider pp = new ProductProvider();
        pp.setCodigo(this.getCodigo());
        pp.setColor(this.getColor());
        pp.setTalle(this.getTalle());
        pp.setStock(this.getStock());
        pp.setFoto(this.getFoto());
        return pp;
    }
}
