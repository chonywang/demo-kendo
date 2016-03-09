package pe.cpsaa.sac.concreto.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

@SuppressWarnings("deprecation")
public class JasperReportUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static File exportarAFile(String rutaCarpeta, String rutaArchivoJasper, List dataSource, Map parametros, String nombreExport, 
			String modoReporte, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
		
		String extencionArchivo = null;
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){
			extencionArchivo = Constantes.JasperReport.EXTENCION_PDF;
		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			extencionArchivo = Constantes.JasperReport.EXTENCION_EXCEL;
		}
		
		if(request!=null){
			rutaArchivoJasper = request.getRealPath(rutaArchivoJasper);
		}
		
		JasperPrint jasperPrint = null;
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(rutaArchivoJasper, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(rutaArchivoJasper, parametros, new JREmptyDataSource());
		}
		
		File reporteFile = new File(rutaCarpeta + nombreExport + extencionArchivo);
		
		OutputStream outputStream = new FileOutputStream(reporteFile);
		
		JRExporter exporter = null;
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){
			exporter = new JRPdfExporter();
		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			exporter = new JRXlsExporter();
		}
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream); // your output goes here
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){

		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//			exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
		}
		
		exporter.exportReport();		
		outputStream.close();
		
		return reporteFile;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static File exportarGerencialAFile(String rutaCarpeta, String rutaArchivoJasper, List dataSource, Map parametros, String nombreExport, 
			String modoReporte, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
		
		String extencionArchivo = null;
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){
			extencionArchivo = Constantes.JasperReport.EXTENCION_PDF;
		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			extencionArchivo = Constantes.JasperReport.EXTENCION_EXCEL;
		}
		
		if(request!=null){
			rutaArchivoJasper = request.getRealPath(rutaArchivoJasper);
		}
		
		JasperPrint jasperPrint = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(rutaArchivoJasper);
		
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
		}
		File reporteFile = new File(rutaCarpeta + nombreExport + extencionArchivo);
		
		OutputStream outputStream = new FileOutputStream(reporteFile);
		
		JRExporter exporter = null;
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){
			exporter = new JRPdfExporter();
		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			exporter = new JRXlsExporter();
		}
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream); // your output goes here
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){

		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//			exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
		}
		
		exporter.exportReport();		
		outputStream.close();
		
		return reporteFile;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static File exportarCartaControlAFile(String rutaCarpeta, String rutaArchivoJasper, List dataSource, Map parametros, String nombreExport, 
			String modoReporte, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
		
		String extencionArchivo = null;
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){
			extencionArchivo = Constantes.JasperReport.EXTENCION_PDF;
		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			extencionArchivo = Constantes.JasperReport.EXTENCION_EXCEL;
		}
		
		if(request!=null){
			rutaArchivoJasper = request.getRealPath(rutaArchivoJasper);
		}
		
		JasperPrint jasperPrint = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(rutaArchivoJasper);
		
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
		}
		
		File reporteFile = new File(rutaCarpeta + nombreExport + extencionArchivo);
		
		OutputStream outputStream = new FileOutputStream(reporteFile);
		
		JRExporter exporter = null;
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){
			exporter = new JRPdfExporter();
		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			exporter = new JRXlsExporter();
		}
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream); // your output goes here
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){

		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//			exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
		}
		
		exporter.exportReport();		
		outputStream.close();
		
		return reporteFile;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static File exportarCertificadoCalidadAFile(String rutaCarpeta, String rutaArchivoJasper, List dataSource, Map parametros, String nombreExport, 
			String modoReporte, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
		
		String extencionArchivo = null;
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){
			extencionArchivo = Constantes.JasperReport.EXTENCION_PDF;
		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			extencionArchivo = Constantes.JasperReport.EXTENCION_EXCEL;
		}
		System.out.println(JasperReportUtil.class.getResource("/"));
		
//		if(request!=null){
//			rutaArchivoJasper = request.getRealPath(rutaArchivoJasper);
//		}
	
		
		JasperPrint jasperPrint = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(rutaArchivoJasper);
		
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
		}
		
		File reporteFile = new File(rutaCarpeta + nombreExport + extencionArchivo);
		
		OutputStream outputStream = new FileOutputStream(reporteFile);
		
		JRExporter exporter = null;
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){
			exporter = new JRPdfExporter();
		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			exporter = new JRXlsExporter();
		}
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream); // your output goes here
		
		if(Constantes.JasperReport.MODO_REPORTE_PDF.equalsIgnoreCase(modoReporte)){

		}else if(Constantes.JasperReport.MODO_REPORTE_EXCEL.equalsIgnoreCase(modoReporte)){
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//			exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
		}
		
		exporter.exportReport();		
		outputStream.close();
		
		return reporteFile;
	}
	
	public static void exportarPdfDownload(String nombrePdf,
											String rutaArchivoJasper,
											Map<String,Object> parametros,
											List<?> dataSource,
											HttpServletRequest request, 
											HttpServletResponse response,
											String modoExportacion) throws JRException, IOException {
		
		if(parametros == null){
			parametros = new HashMap<String, Object>();
		}
				
		JasperPrint jasperPrint = null;
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(request.getRealPath(rutaArchivoJasper), parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(request.getRealPath(rutaArchivoJasper), parametros, new JREmptyDataSource());
		}
		
		
		
		/*******************************************************************
		******************************************************************/
//		JRPdfExporter exporter = new JRPdfExporter();
//		exporter.setParameter(JRExporterParameter., value);
		
		byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		
		
		ServletOutputStream ouputStream = response.getOutputStream(); 
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", modoExportacion+"; filename="+nombrePdf+".pdf");
		response.setHeader("Cache-Control", "public");
		response.setHeader("Pragma", "public");
		ouputStream.write(bytes);
		ouputStream.flush();
		ouputStream.close();
		response.flushBuffer();
		
	}
	
	public static void exportarPdfGerencialDownload(String nombrePdf,
			String rutaArchivoJasper,
			Map<String,Object> parametros,
			List<?> dataSource,
			HttpServletRequest request, 
			HttpServletResponse response,
			String modoExportacion) throws JRException, IOException {

		if(parametros == null){
		parametros = new HashMap<String, Object>();
		}
		
		JasperPrint jasperPrint = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(request.getRealPath(rutaArchivoJasper));
		
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
		}
		
		/*******************************************************************
		******************************************************************/
		//JRPdfExporter exporter = new JRPdfExporter();
		//exporter.setParameter(JRExporterParameter., value);
		
		byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		
		
		ServletOutputStream ouputStream = response.getOutputStream(); 
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", modoExportacion+"; filename="+nombrePdf+".pdf");
		response.setHeader("Cache-Control", "public");
		response.setHeader("Pragma", "public");
		ouputStream.write(bytes);
		ouputStream.flush();
		ouputStream.close();
		response.flushBuffer();
		
	}
	
	public static void exportarPdfCartaControlDownload(String nombrePdf,
			String rutaArchivoJasper,
			Map<String,Object> parametros,
			List<?> dataSource,
			HttpServletRequest request, 
			HttpServletResponse response,
			String modoExportacion) throws JRException, IOException {

		if(parametros == null){
		parametros = new HashMap<String, Object>();
		}
		
		JasperPrint jasperPrint = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(request.getRealPath(rutaArchivoJasper));
		
		
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
		}
		
		
		
		/*******************************************************************
		******************************************************************/
		//JRPdfExporter exporter = new JRPdfExporter();
		//exporter.setParameter(JRExporterParameter., value);
		
		byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		
		
		ServletOutputStream ouputStream = response.getOutputStream(); 
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", modoExportacion+"; filename="+nombrePdf+".pdf");
		response.setHeader("Cache-Control", "public");
		response.setHeader("Pragma", "public");
		ouputStream.write(bytes);
		ouputStream.flush();
		ouputStream.close();
		response.flushBuffer();
		
	}
	
	public static void exportarPdfCertificadoCalidadDownload(String nombrePdf,
			String rutaArchivoJasper,
			Map<String,Object> parametros,
			List<?> dataSource,
			HttpServletRequest request, 
			HttpServletResponse response,
			String modoExportacion) throws JRException, IOException {

		if(parametros == null){
		parametros = new HashMap<String, Object>();
		}
		
		JasperPrint jasperPrint = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(request.getRealPath(rutaArchivoJasper));
		
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
		}
		
		
		
		/*******************************************************************
		******************************************************************/
		//JRPdfExporter exporter = new JRPdfExporter();
		//exporter.setParameter(JRExporterParameter., value);
		
		byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		
		
		ServletOutputStream ouputStream = response.getOutputStream(); 
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", modoExportacion+"; filename="+nombrePdf+".pdf");
		response.setHeader("Cache-Control", "public");
		response.setHeader("Pragma", "public");
		ouputStream.write(bytes);
		ouputStream.flush();
		ouputStream.close();
		response.flushBuffer();
		
		}
	
		public static void exportarExcelDownload(String nombreXls,
												String rutaArchivoJasper,
												Map<String,Object> parametros,
												List<?> dataSource,
												HttpServletRequest request, 
												HttpServletResponse response) throws JRException, IOException {
		
		
		if(parametros == null){
			parametros = new HashMap<String, Object>();
		}
		
		parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
		
		JasperPrint jasperPrint = null;
		if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(request.getRealPath(rutaArchivoJasper), parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
			jasperPrint = JasperFillManager.fillReport(request.getRealPath(rutaArchivoJasper), parametros, new JREmptyDataSource());
		}
		
		
				
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		JRXlsExporter exporter = new JRXlsExporter();  
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//		exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.FALSE);		
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.exportReport();
        // Send response
        byte[] bytes = baos.toByteArray();
        /*******************************************************************
         ******************************************************************/
        ServletOutputStream ouputStream = response.getOutputStream(); 
		response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment; filename="+nombreXls+".xls");
        response.setHeader("Cache-Control", "public");
		response.setHeader("Pragma", "public");
		ouputStream.write(bytes);
		ouputStream.flush();
		ouputStream.close();
		response.flushBuffer();
		
	}
		
	public static void exportarExcelGerencialDownload(String nombreXls,
			String rutaArchivoJasper,
			Map<String,Object> parametros,
			List<?> dataSource,
			HttpServletRequest request, 
			HttpServletResponse response) throws JRException, IOException {
		
		if(parametros == null){
			parametros = new HashMap<String, Object>();
		}
		
		parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
		
//		JasperPrint jasperPrint = null;
//		if(dataSource!=null && dataSource.size()>0){
//			jasperPrint = JasperFillManager.fillReport(request.getRealPath(rutaArchivoJasper), parametros, new JRBeanCollectionDataSource(dataSource));
//		}else{
//			jasperPrint = JasperFillManager.fillReport(request.getRealPath(rutaArchivoJasper), parametros, new JREmptyDataSource());
//		}
		
		JasperPrint jasperPrint = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(request.getRealPath(rutaArchivoJasper));
		if(dataSource!=null && dataSource.size()>0){
		jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
		jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
		}
		
		
				
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		JRXlsExporter exporter = new JRXlsExporter();  
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
//		exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.FALSE);		
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.exportReport();
        // Send response
        byte[] bytes = baos.toByteArray();
        /*******************************************************************
         ******************************************************************/
        ServletOutputStream ouputStream = response.getOutputStream(); 
		response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment; filename="+nombreXls+".xls");
        response.setHeader("Cache-Control", "public");
		response.setHeader("Pragma", "public");
		ouputStream.write(bytes);
		ouputStream.flush();
		ouputStream.close();
		response.flushBuffer();
	}
		

	public static void exportarExcelCartaControlDownload(String nombreXls,
				String rutaArchivoJasper,
				Map<String,Object> parametros,
				List<?> dataSource,
				HttpServletRequest request, 
				HttpServletResponse response) throws JRException, IOException {


		if(parametros == null){
		parametros = new HashMap<String, Object>();
		}
		
		parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
		
		JasperPrint jasperPrint = null;
		JasperReport jasperReport = JasperCompileManager.compileReport(request.getRealPath(rutaArchivoJasper));
		if(dataSource!=null && dataSource.size()>0){
		jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
		}else{
		jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		JRXlsExporter exporter = new JRXlsExporter();  
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		//exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.FALSE);		
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.exportReport();
		// Send response
		byte[] bytes = baos.toByteArray();
		/*******************************************************************
		******************************************************************/
		ServletOutputStream ouputStream = response.getOutputStream(); 
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment; filename="+nombreXls+".xls");
		response.setHeader("Cache-Control", "public");
		response.setHeader("Pragma", "public");
		ouputStream.write(bytes);
		ouputStream.flush();
		ouputStream.close();
		response.flushBuffer();
		
	}
		
	public static void exportarExcelCertificadoCalidadDownload(String nombreXls,
				String rutaArchivoJasper,
				Map<String,Object> parametros,
				List<?> dataSource,
				HttpServletRequest request, 
				HttpServletResponse response) throws JRException, IOException {

			
			if(parametros == null){
			parametros = new HashMap<String, Object>();
			}
			
			parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
			
			JasperPrint jasperPrint = null;
			JasperReport jasperReport = JasperCompileManager.compileReport(request.getRealPath(rutaArchivoJasper));
			if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
			}else{
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
			}
			
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();  
			JRXlsExporter exporter = new JRXlsExporter();  
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			//exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.FALSE);		
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();
			// Send response
			byte[] bytes = baos.toByteArray();
			/*******************************************************************
			******************************************************************/
			ServletOutputStream ouputStream = response.getOutputStream(); 
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="+nombreXls+".xls");
			response.setHeader("Cache-Control", "public");
			response.setHeader("Pragma", "public");
			ouputStream.write(bytes);
			ouputStream.flush();
			ouputStream.close();
			response.flushBuffer();
			
		}
	
		public static void exportarExcelConsultaEnsayoDownload(String nombreXls,
				String rutaArchivoJasper,
				Map<String,Object> parametros,
				List<?> dataSource,
				HttpServletRequest request, 
				HttpServletResponse response) throws JRException, IOException {
	
			
			if(parametros == null){
			parametros = new HashMap<String, Object>();
			}
			
			parametros.put(JRParameter.REPORT_LOCALE, Locale.US);
			
			JasperPrint jasperPrint = null;
			JasperReport jasperReport = JasperCompileManager.compileReport(request.getRealPath(rutaArchivoJasper));
			if(dataSource!=null && dataSource.size()>0){
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JRBeanCollectionDataSource(dataSource));
			}else{
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());
			}
			
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();  
			JRXlsExporter exporter = new JRXlsExporter();  
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			//exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.FALSE);		
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();
			// Send response
			byte[] bytes = baos.toByteArray();
			/*******************************************************************
			******************************************************************/
			ServletOutputStream ouputStream = response.getOutputStream(); 
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="+nombreXls+".xls");
			response.setHeader("Cache-Control", "public");
			response.setHeader("Pragma", "public");
			ouputStream.write(bytes);
			ouputStream.flush();
			ouputStream.close();
			response.flushBuffer();
			
		}
	
	
}
