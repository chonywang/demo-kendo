package pe.cpsaa.sac.concreto.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

//	@Autowired
//	static ParametroSistemaRepository parametroSistemaRepository;
	
	public static Timestamp getFechaHoraActual(){
		
		return new Timestamp(new Date().getTime());
		
	}
	
	public static String getFechaActual(String formato){
		
		String resultado = null;
		
		if(formato!=null && !formato.isEmpty()){
			Date fechaActual = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			resultado = sdf.format(fechaActual);
		}
		
		return resultado;
		
	}
	
	public static String formatearFecha(Timestamp timestamp, String formato){
		
		String resultado = null;
		
		if(timestamp!=null && formato!=null && !formato.isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			resultado = sdf.format(timestamp);
		}
		
		return resultado;
		
	}
	
	public static String formatearFecha(Date date, String formato){
		
		String resultado = null;
		
		if(date!=null && formato!=null && !formato.isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			resultado = sdf.format(date);
		}
		
		return resultado;
	}
	
	public static Timestamp convertirFecha(String strFecha, String formatoOrigen){
		Timestamp resultado = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatoOrigen);		
			if(strFecha!=null && !strFecha.trim().isEmpty()){
				Date fecha = sdf.parse(strFecha);
				resultado = new Timestamp(fecha.getTime());
			}			
		} catch (ParseException e) {
			resultado = null;
			e.printStackTrace();
		}
		
		return resultado;
	}
		
	public static Timestamp restarFechasTimestamp(Timestamp f1, Timestamp f2){		
		return new Timestamp(f1.getTime()-f2.getTime());		
	}
	
	public static String obtenerDiferenciaFechasEnHorasMinutos (Timestamp f1, Timestamp f2){
		String strHoraRetraso = null;
		
		String strDiferenciaHoras = "";
		String strDiferenciaMinutos = "";
		
		Long f1EnMillis = f1.getTime();
		Long f2EnMillis = f2.getTime();
		
		Long diferencia = f1EnMillis - f2EnMillis;
		
		
        // calcular la diferencia en horas
        long diffHours = diferencia / Constantes.Fechas.MILISEGUNDOS_POR_HORA;
        
        diferencia = diferencia % Constantes.Fechas.MILISEGUNDOS_POR_HORA;
		
		// calcular la diferencia en minutos
        long diffMinutes = diferencia / Constantes.Fechas.MILISEGUNDOS_POR_MINUTO;
        

        if(diffHours!=0){
        	strDiferenciaHoras = diffHours + " Horas ";
        }
        if(diffMinutes!=0){
        	strDiferenciaMinutos = diffMinutes + " Minutos";
        }
        
        
        strHoraRetraso =  (strDiferenciaHoras + strDiferenciaMinutos).trim();
        		
		
		return strHoraRetraso;
	}
	
	public static Timestamp aumentarDiasFecha(Timestamp fechaOriginal, int dias) {
		return sumaTiempo(fechaOriginal, Calendar.DAY_OF_MONTH, dias);
	}
	
	private static Timestamp sumaTiempo(Timestamp fechaOriginal, int field, int amount) {
		Calendar calendario = new GregorianCalendar();
		calendario.setTimeInMillis(fechaOriginal.getTime());
		calendario.add(field, amount);
		Timestamp fechaResultante = new Timestamp(calendario.getTimeInMillis());

		return fechaResultante;
	}
	
	public static Timestamp aumentarDiasFechaTimestamp(Timestamp fechaOriginal, int dias) {
		//return sumaTiempo(fechaOriginal, Calendar.DAY_OF_MONTH, dias);
		Calendar calendario = new GregorianCalendar();
		calendario.setTimeInMillis(fechaOriginal.getTime());
		calendario.add(Calendar.DAY_OF_YEAR, dias);
		Timestamp fechaResultante = new Timestamp(calendario.getTimeInMillis());

		return fechaResultante;
	}
	
	public static Long obtenerAnioValido(Timestamp fecha, String horaInicioActividades){
		
//		String anioValido = null;
		
		Long anio = null;
		// obtenemos el comienzo del turno
//		String horaInicioActividades = "07:00";
//		ParametroSistema param = parametroSistemaRepository.obtenerParametroSistemaPorId(Constantes.ParametrosSistema.SISTEMA_HORA_INICIO_ACTIVIDADES_ID);
//		horaInicioActividades = param.getValor(); 
//		ParametroSistema parTurnoIniA = (ParametroSistema) SACFastDomainHelper.getInstance().getParametroSistema(Long.valueOf(ConstantesParametro.SISTEMA_HORA_INICIO_ACTIVIDADES));
		
		
//		Timestamp fecha = getFechaHoraActual();
		String anioSistema = formatearFecha(fecha, Constantes.Fechas.FORMATO_yyyy);
		
		
		String fecha00 = (anioSistema) + "/01/01 00:00:00";
		String fecha01 = (anioSistema) + "/01/01 " + horaInicioActividades + ":00";
		
//
		Timestamp f00 = convertirFecha(fecha00, Constantes.Fechas.FORMATO_dd_MM_yyyy_HH_mm);
		Timestamp f01 = convertirFecha(fecha01, Constantes.Fechas.FORMATO_dd_MM_yyyy_HH_mm);
//
		
		if(fecha.after(f00) && fecha.before(f01)){
			anio = NumeroUtil.stringToLong(anioSistema) - 1;
		}else{
			anio = NumeroUtil.stringToLong(anioSistema);
		}
		
//		if (FechaUtil.timestampIsMenor(fecha, f00) && FechaUtil.timestampIsMayor(fecha, f01)) {
//			anio = new Long(NumeroUtil.stringToLong(FechaUtil.TimestampToStringAAAA(fecha)).intValue() - 1);
//		} else {
//			anio = NumeroUtil.stringToLong(FechaUtil.TimestampToStringAAAA(fecha));
//		}
		
		return anio;
		
	}
	
}
