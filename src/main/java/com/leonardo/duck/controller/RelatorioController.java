package com.leonardo.duck.controller;

import com.leonardo.duck.service.RelatorioService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.sql.SQLException;

@RequestMapping("/gerar-relatorio")
@RestController
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping
    public ResponseEntity<byte[]> gerarRelatorio(HttpServletResponse response) throws IOException, SQLException {
        byte[] relatorio = relatorioService.gerarRelatorio();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "relatorio.pdf");

        return new ResponseEntity<>(relatorio, headers, HttpStatus.OK);
    }
}
