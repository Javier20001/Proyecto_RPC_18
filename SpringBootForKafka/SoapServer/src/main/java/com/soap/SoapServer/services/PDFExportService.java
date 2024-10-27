package com.soap.SoapServer.services;


import com.soap.SoapServer.dtos.ProductoEnOCDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PDFExportService {
    public byte[] generatePdf(List<ProductoEnOCDTO> productos, String catalogoTitulo) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            // Crear un flujo de contenido para la página
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText(catalogoTitulo);
                contentStream.endText();

                contentStream.setFont(PDType1Font.HELVETICA, 12);
                float yPosition = 650; // Posición inicial para los productos

                // Agregar cada producto al PDF
                for (ProductoEnOCDTO producto : productos) {
                    contentStream.beginText();
                    contentStream.newLineAtOffset(100, yPosition);
                    contentStream.showText("Codigo: " + producto.getCodigo());
                    contentStream.endText();

                    contentStream.beginText();
                    contentStream.newLineAtOffset(100, yPosition - 15);
                    contentStream.showText("Colores: " + String.join(", ", producto.getColor()));
                    contentStream.endText();

                    contentStream.beginText();
                    contentStream.newLineAtOffset(100, yPosition - 30);
                    contentStream.showText("Talles: " + String.join(", ", producto.getTalle()));
                    contentStream.endText();

                    // Puedes agregar lógica para incluir imágenes de los productos si es necesario
                    yPosition -= 50; // Espaciado entre productos
                }
            }

            // Guardar el documento en un flujo de salida
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray(); // Retornar el PDF como un array de bytes
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Manejo de errores, puedes lanzar una excepción
        }
    }
}