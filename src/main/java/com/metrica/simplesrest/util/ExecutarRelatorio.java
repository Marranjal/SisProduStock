/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrica.simplesrest.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

/**
 *
 * @author Teste
 */
public class ExecutarRelatorio {

    private String caminhoDoRelatorio;
    private Map<String, Object> parametros;
    private String nomeArquivoSaida;

    private Connection connection = null;

    public ExecutarRelatorio(String caminhoDoRelatorio, Map parametros, String nomeArquivoSaida) {
        this.caminhoDoRelatorio = caminhoDoRelatorio;
        this.parametros = parametros;
        this.nomeArquivoSaida = nomeArquivoSaida;
    }

    public void executaReport() throws SQLException {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

        try {
            connection = Conexao.getConnection();

            //Pegar o fluxo do ficheiro .jasper passado pelo caminho
            InputStream relatorioStream = this.getClass().getResourceAsStream(this.caminhoDoRelatorio);

            //Colocar este fluxo no objecto JasperPrint com a conexão e o parametro
            JasperPrint print = JasperFillManager.fillReport(relatorioStream, parametros, connection);

            JRPdfExporter exportarPdf = new JRPdfExporter();

            exportarPdf.setExporterInput(new SimpleExporterInput(print));
            exportarPdf.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + this.nomeArquivoSaida + "\"");

            exportarPdf.exportReport();
            
            context.responseComplete();

        } catch (Exception e) {
            throw new SQLException("Erro ao executar o relatorio: " + e);
        }

    }
    
    //  public void ImprimirRelatorio(String caminho, Map parametros) {
    public void ImprimirRelatorio() {
        try {
            try {
                connection = Conexao.getConnection();
            } catch (Exception ex) {

            }

            //System.out.println("-----------------------------Conn "+conn.getSchema());
            ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

            byte[] bytes = null;

            // load report location
            FileInputStream fis = new FileInputStream(context.getRealPath(caminhoDoRelatorio));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);

            // carrega os arquivos jasper
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject(bufferedInputStream);
            // parâmetros, se houverem
         
            FacesContext context2 = FacesContext.getCurrentInstance();
            context2.responseComplete();
            bytes = JasperRunManager.runReportToPdf(relatorioJasper, parametros, connection);

            HttpServletResponse response = (HttpServletResponse) context2.getExternalContext().getResponse();

            if (bytes != null && bytes.length > 0) {

                response.setContentType("application/pdf");
                //response.addHeader("Content-disposition", "inline; filename=\"relatorio.pdf\"");
                response.setContentLength(bytes.length);

                ServletOutputStream ouputStream = response.getOutputStream();

                ouputStream.write(bytes, 0, bytes.length);

                ouputStream.flush();

                //ouputStream.close();
                //System.out.println("Certo4-----------------------------");
                context2.getApplication().getStateManager().saveView(context2);
                context2.responseComplete();
            }

        } catch (JRException jre) {
            System.err.println("Erro" + jre);
        } catch (IOException ioe) {
            System.err.println("Erro" + ioe);
        }
    }

}
