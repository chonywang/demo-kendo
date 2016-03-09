package pe.cpsaa.sac.concreto.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Util {

	
	
	public static Object getObjetoSesion(String id){
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		Object objectSession = attr.getRequest().getSession().getAttribute(id);

		return objectSession;
		
	}
	
	public static void setObjetoSesion(String id, Object objeto){
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		attr.getRequest().getSession().setAttribute(id, objeto);
		
	}
	
	public static String obtenerNombreImagenFocoPorEstado(String estado){
		
		String nombreImagenFoco = null;
				
		switch (estado) {
			case Constantes.IngresoCurado.ESTADO_REGISTRADO : 
						nombreImagenFoco = "focoAceptableGrande.gif";
						break;
			case Constantes.IngresoCurado.ESTADO_INGRESO_A_CURADO_A_TIEMPO : 
						nombreImagenFoco = "focoPreventivoGrande.gif";
						break;
			case Constantes.IngresoCurado.ESTADO_INGRESO_A_CURADO_FUERA_DE_TIEMPO : 
						nombreImagenFoco = "focoPrecaucionGrande.gif";
						break;
			case Constantes.IngresoCurado.ESTADO_PENDIENTE_INGRESO_A_CURADO : 
						nombreImagenFoco = "focoProblemaGrande.gif";
						break;
		}
		
		return nombreImagenFoco;
		
	}
	
	public static String obtenerDescripcionTipoEstadoIngresoCurado(String estado){
		String descripcion = null;
		
		switch (estado) {
			case Constantes.IngresoCurado.ESTADO_REGISTRADO : 
				descripcion = "Registrado";
						break;
			case Constantes.IngresoCurado.ESTADO_INGRESO_A_CURADO_A_TIEMPO : 
				descripcion = "Ingreso a curado a tiempo";
						break;
			case Constantes.IngresoCurado.ESTADO_INGRESO_A_CURADO_FUERA_DE_TIEMPO : 
				descripcion = "Ingreso a curado fuera de tiempo";
						break;
			case Constantes.IngresoCurado.ESTADO_PENDIENTE_INGRESO_A_CURADO : 
				descripcion = "Pendiente de ingreso a curado";
						break;
		}		
		
		return descripcion;
	}
	
	public static List<?> extraerDto(List<?> listaOrigen, Class<?> claseDestino){
		
		List<?> listaDestino = null;
		
//		for () {
//			
//		}		
		
		return listaDestino;
		
	}
	
	
	public static String completarCerosIzquierda(Long numero, int tamanioCadena){
		String resultado = null;
		
		int tamanioNumero = String.valueOf(numero).length();
		int tamanioCompletarCeros = tamanioCadena - tamanioNumero;
		
		StringBuffer sb = new StringBuffer();		
		for ( int i=0;i < tamanioCompletarCeros;i++) {
		  sb.append( "0");
		}
		sb.append(numero);
		resultado = sb.toString();		
		
		return resultado;
	}
	
	public static Double redondeoDosDecimales(Double numero){
		double valor = Math.rint(numero*100)/100;
		return new Double(valor);
	}
	
	public static Double redondeoSinDecimales(Double numero){
		double valor = (double) Math.round(numero); 
	       return new Double(valor);
	}
	
	public static Double calcularArea(Double diametro){
		Double radio = diametro/2;
		return Math.PI*Math.pow(radio,2);
	}
	
	public static String concadenarItemsLista(List<?> lista,String separador){
		
		StringBuilder sb = null;
		String resultado = "";
		
		if(lista!=null && lista.size()>0){
			
			sb = new StringBuilder();
			
			for(int i=0;i<lista.size();i++){
				if(i>0){
					sb.append(" ");
					sb.append(separador);
				}
				sb.append(lista.get(i));
			}
			
			resultado = sb.toString();
		}		
		
		return resultado;
		
	}
	
	/**
	 * 
	 */
	public static List<String> obtenerRutaFirmasPorSiglaPlanta(String siglaPlanta){
		
		List<String> rutasFirma = null;
		String rutaFirma1 = null;
		String rutaFirma2 = null;
		String rutaNombrePlanta = null;
		
		
		if(siglaPlanta!=null){
			rutaFirma1 = "/resources/images/firmas/";
			rutaFirma2 = "/resources/images/firmas/";
			rutasFirma = new ArrayList<String>();
			switch (siglaPlanta) {
				case Constantes.Plantas.SIGLA_PLANTA_CHIMBOTE:
					rutaNombrePlanta = "Chimbote/";
					break;
				case Constantes.Plantas.SIGLA_PLANTA_TRUJILLO:
					rutaNombrePlanta = "Trujillo/";
					break;
				case Constantes.Plantas.SIGLA_PLANTA_PACASMAYO:
					rutaNombrePlanta = "Pacasmayo/";
					break;
				case Constantes.Plantas.SIGLA_PLANTA_CHICLAYO:
					rutaNombrePlanta = "Chiclayo/";
					break;
				case Constantes.Plantas.SIGLA_PLANTA_PIURA:
					rutaNombrePlanta = "Piura/";
					break;
				case Constantes.Plantas.SIGLA_PLANTA_CAJAMARCA:
					rutaNombrePlanta = "Cajamarca/";
					break;
				case Constantes.Plantas.SIGLA_PLANTA_JAEN:
					rutaNombrePlanta = "Jaen/";
					break;
			}
			
			rutasFirma.add(rutaFirma1 + rutaNombrePlanta + "Firma1.gif");
			rutasFirma.add(rutaFirma2 + rutaNombrePlanta + "Firma2.gif");
						
		}
		
		return rutasFirma;
		
	}
	
}
