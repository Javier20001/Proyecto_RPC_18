package com.soap.SoapServer.soapservices.responses;

import com.soap.SoapServer.dtos.OrdenDeCompraDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllOrdenesDeCompraResponse", propOrder = {
        "ordenesDeCompra"
})
public class GetAllOrdenesDeCompraResponse {

    private List<OrdenDeCompraDTO> ordenesDeCompra;

    public List<OrdenDeCompraDTO> getOrdenesDeCompra() {
        return ordenesDeCompra;
    }

    public void setOrdenesDeCompra(List<OrdenDeCompraDTO> ordenesDeCompra) {
        this.ordenesDeCompra = ordenesDeCompra;
    }
}
