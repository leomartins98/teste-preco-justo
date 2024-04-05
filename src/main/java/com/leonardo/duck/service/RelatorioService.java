package com.leonardo.duck.service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

@Service
public class RelatorioService implements Serializable {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public byte[] gerarRelatorio() throws IOException, SQLException {

        Connection connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();

        try {
            // Compilar o arquivo jrxml para o formato .jasper
            JasperCompileManager.compileReportToFile(
                    new ClassPathResource("relatorio/relatorioPatos.jrxml").getFile().getPath(),
                    new ClassPathResource("relatorio/relatorioPatos.jasper").getFile().getPath()
            );

            // Preencher o relatório
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    new ClassPathResource("relatorio/relatorioPatos.jasper").getFile().getPath(), // Caminho do arquivo .jasper
                    new HashMap<>(), // Parâmetros do relatório, se houverem
                    connection);

            // Exportar o relatório para bytes (PDF)
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

            return baos.toByteArray();
        } catch (JRException e) {
            e.printStackTrace();
            throw new IOException("Erro ao gerar o relatório", e);
        }
    }
}
