package pe.cpsaa.sac.concreto.util;

import java.util.Arrays;
import java.util.List;

public class NumeroUtil {

	
	public static Double promedio3Numeros(Double numero1, Double numero2, Double numero3){
		Double resultado = null;
		
		List<Double> listaNumeros = Arrays.asList(numero1,numero2,numero3);
		Double cantidad = null;
		Double totalAcumulado = null;
		
		for(Double numeroLista : listaNumeros){
			if(numeroLista!=null){
				if(totalAcumulado==null){
					totalAcumulado = numeroLista;
					cantidad = 1d;
				}else{
					totalAcumulado = totalAcumulado + numeroLista;
					cantidad++;
				}
			}
		}
		
		if(cantidad!=null && totalAcumulado!=null){
			resultado = totalAcumulado / cantidad;
		}
		
		return resultado;
	}
	
	public static Long promedio3Numeros(Long numero1, Long numero2, Long numero3){
		Long resultado = null;
		
		List<Long> listaNumeros = Arrays.asList(numero1,numero2,numero3);
		Long cantidad = null;
		Long totalAcumulado = null;
		
		for(Long numeroLista : listaNumeros){
			if(numeroLista!=null){
				if(totalAcumulado==null){
					totalAcumulado = numeroLista;
					cantidad = 1l;
				}else{
					totalAcumulado = totalAcumulado + numeroLista;
					cantidad++;
				}
			}
		}
		
		if(cantidad!=null && totalAcumulado!=null){
			resultado = totalAcumulado / cantidad;
		}
		
		return resultado;
	}
	
	public static Long stringToLong(String cadena){
		Long numero = null;
		if(cadena!=null && !cadena.trim().isEmpty()){
			numero = Long.parseLong(cadena);
		}
		return numero;		
	}
	
	public static Integer stringToInteger(String cadena){
		Integer numero = null;
		if(cadena!=null && !cadena.trim().isEmpty()){
			numero = Integer.parseInt(cadena);
		}
		return numero;		
	}
	
	public static Double stringToDouble(String cadena){
		Double numero = null;
		if(cadena!=null && !cadena.trim().isEmpty()){
			numero = Double.parseDouble(cadena);
		}
		return numero;		
	}
	
	public static Float stringToFloat(String cadena){
		Float numero = null;
		if(cadena!=null && !cadena.trim().isEmpty()){
			numero = Float.parseFloat(cadena);
		}
		return numero;		
	}
	
	
	public static Long doubleToLong(Double decimal){
		
		Long numeroRedondeado = null;
		
		if(decimal!=null){
			numeroRedondeado = Math.round(decimal);
		}
		
		return numeroRedondeado;
		
	}
	
	public static Double redondear(Double decimal, Integer cantDecimales){
		
		Double redondeado = null;
		
		if(decimal!=null){
			
			Integer cifras = (int) Math.pow(10, cantDecimales);
			
			redondeado = Math.rint(decimal* cifras )/ cifras ;
		}
		
		return redondeado;
		
	}
	
}
