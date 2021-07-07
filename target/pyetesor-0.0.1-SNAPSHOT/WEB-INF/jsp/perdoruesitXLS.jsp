<%@page contentType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.engine.data.*" %>
<%@page import="java.io.*" %>
<%@page import=" java.util.*" %>
<%@ page import="net.sf.jasperreports.engine.export.JRXlsExporter" %>
<%@ page import="net.sf.jasperreports.engine.export.JRXlsExporterParameter" %>
<%@ page import="net.sf.jasperreports.export.SimpleExporterInput" %>
<%@ page import="net.sf.jasperreports.export.SimpleOutputStreamExporterOutput" %>
<%@ page import="net.sf.jasperreports.export.SimpleXlsReportConfiguration" %>
<%@ page import="net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter" %>
<%@ page import="net.sf.jasperreports.export.SimpleXlsxReportConfiguration" %>

<%

    try {
        List<Map<String, ?>> dataSource = (List<Map<String, ?>>) request.getAttribute("listPerdoruesit");
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
        String jrxmlFile = session.getServletContext().getRealPath("classpath: /reports/seminaret.jrxml");
        InputStream input = new FileInputStream(new File("C:\\Users\\olsio\\OneDrive - Fakulteti i Teknologjise se Informacionit\\Diploma\\pyetesor\\src\\main\\resources\\reports\\perdoruesit.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(input);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);

        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setWhitePageBackground(false);
        configuration.setOnePagePerSheet(true);
        configuration.setRemoveEmptySpaceBetweenRows(true);
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        configuration.setDetectCellType(true);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
%>
