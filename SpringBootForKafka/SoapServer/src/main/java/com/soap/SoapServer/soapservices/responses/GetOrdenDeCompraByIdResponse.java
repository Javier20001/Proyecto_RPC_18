package com.soap.SoapServer.soapservices.responses;

import com.soap.SoapServer.dtos.OrdenDeCompraDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrdenDeCompraByIdResponse", propOrder = {
        "ordenDeCompra"
})
public class GetOrdenDeCompraByIdResponse {

    private OrdenDeCompraDTO ordenDeCompra;

    public OrdenDeCompraDTO getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(OrdenDeCompraDTO ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

}
