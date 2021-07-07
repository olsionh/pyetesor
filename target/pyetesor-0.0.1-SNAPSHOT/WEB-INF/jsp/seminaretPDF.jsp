<%@page contentType="application/pdf"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.engine.data.*" %>
<%@page import="java.io.*" %>
<%@page import=" java.util.*" %>

<%

    try {
        List<Map<String, ?>> dataSource = (List<Map<String, ?>>) request.getAttribute("listSeminaret");
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
        String jrxmlFile = session.getServletContext().getRealPath("classpath: /reports/seminaret.jrxml");
        InputStream input = new FileInputStream(new File("C:\\Users\\olsio\\OneDrive - Fakulteti i Teknologjise se Informacionit\\Diploma\\pyetesor\\src\\main\\resources\\reports\\seminaret.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(input);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
    catch (Exception e)
    {

    }
%>
