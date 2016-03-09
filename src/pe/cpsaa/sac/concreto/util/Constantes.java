package pe.cpsaa.sac.concreto.util;

public class Constantes {

	public static final String VAR_VACIO = "";
	public static final String VAR_GUION = "-";
	public static final String INDICADOR_FLEXION = "(Mr)";
	public static final String VAR_CERO = "0";
	public static final String EXITO = "La operacion se realiz\u00f3 con \u00e9xito.";
	public static final String ERROR_EMPRESA = "La Empresa no existe.";
	public static final String ERROR_PLANTA = "La Planta no existe.";
	public static final String ERROR_PRODUCTO = "El Producto no existe.";
	public static final String ERROR = "Error de sistema.";
	public static final String ERROR_PEDIDO = "El numero de pedido ya existe, relacione con el codigo pedido padre.";
	public static final String ERROR_PEDIDO_PADRE = "El numero de pedido no existe, ingrese el numero de pedido padre correcto.";
	
	public static final String USUARIO_SESION = "usuarioSesion";
	public static final String FLAG_RECORDAR_USUARIO = "flagRecordarUsuario";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";	
	
	public static final String FORMATO_CORREO_DINO = "@dino.com.pe";
	
	public static final String URL_WEB_SERVICE_AUTENTICACION = "http://intranet.cpsaa.com.pe/Aplicaciones/WS.nsf/SecurityService?wsdl";
	
	public static final String MENSAJE_CERTIFICADO_CUERPO = "Es grato alcanzarle el Certificado de Calidad, en el que se evidencia la conformidad del concreto suministrado por DINO SRL para su obra . "
															+ "Cabe mencionar que en DINO SRL desarrollamos un exhaustivo programa de Control de Calidad que nos permite garantizar el cumplimiento de sus requisitos.";
	public static final String MENSAJE_CERTIFICADO_ATTE = "Atentamente,";
	public static final String MENSAJE_CERTIFICADO_FIRMA = "Supervisor de Control de Calidad";
	
	public static String Descripcion(String codigo){
		return Constantes.EXITO;
	}
	
	public static final Long REQ_INCIDENCIA_ARENOSO = 1L;
	public static final Long REQ_INCIDENCIA_PEDROSO = 2L;
	public static final Long REQ_SLUM_MUY_SECO = 3L;
	public static final Long REQ_SLUM_MUY_FLUIDO = 4L;
	public static final Long REQ_CONTENIDO_AIRE = 5L;
	public static final Long REQ_TEMPERATURA = 6L;
	public static final Long REQ_GRUMOS = 7L;
	public static final Long REQ_MEZCLA_NO_HOMOGENEA = 8L;
	public static final Long REQ_FALLA_MIXER = 9L;
	public static final Long REQ_CONCRETO_NO_REQUERIDO = 10L;
	public static final Long REQ_MATERIAL_EQUIVOCADO = 11L;
	
	public static final Long CODIGO_IMAGEN_SELECCIONE = 0L;
	public static final Long CODIGO_IMAGEN_TIPO_1 = 1L;
	public static final Long CODIGO_IMAGEN_TIPO_2 = 2L;
	public static final Long CODIGO_IMAGEN_TIPO_3 = 3L;
	public static final Long CODIGO_IMAGEN_TIPO_4 = 4L;
	public static final Long CODIGO_IMAGEN_TIPO_5 = 5L;
	public static final Long CODIGO_IMAGEN_TIPO_6 = 6L;
	
	public static final String ESTADO_COMPARACION_VERDE = "VER";
	public static final String ESTADO_COMPARACION_ROJO = "ROJ";
	public static final String ESTADO_COMPARACION_AMBAR = "AMB";
	public static final String ESTADO_COMPARACION_NO_DEFINIDO = "NOD";
	
	public static final String ESTADO_TRATAMIENTO_CONFORME = "CON";
	public static final String ESTADO_TRATAMIENTO_NO_CONFORME = "NOC";
	public static final String ESTADO_TRATAMIENTO_NO_DEFINIDO = "NOD";
		
	public static final String CODIGO_TIPO_MOLDE_1 = "4-8";
	public static final String CODIGO_TIPO_MOLDE_2 = "6-12";
	
	public static final String ACTIVO_CONTROL = "S";
	public static final String NO_ACTIVO_CONTROL = "N";
		
	public static final Integer TRANSACCION_EXITOSA = 1;
	public static final Integer TRANSACCION_NO_EXITOSA = 0;
	public static final Integer TRANSACCION_NO_RANGO_BARRERA = -99;
	public static final Integer TRANSACCION_NUEVO_LOTE = -98;
	
	public static final String ESTADO_ACTIVO = "ACT";
	public static final String ESTADO_INACTIVO = "INA";
	
	public static final String ESTADO_CIERRE_LOTE_ABIERTO = "A";
	public static final String ESTADO_CIERRE_LOTE_CERRADO = "C";
	
	public static final String INICIALIZACION_CORRELATIVO = "00";
	
	public static final String FLAG_AFIRMATIVO = "S";
	public static final String FLAG_NEGATIVO = "N";
	
	public static final String FLAG_TIPO_COMPRESION = "C";
	public static final String FLAG_TIPO_FLEXION = "F";
	public static final String FLAG_TIPO_COMPRESION_GRAFICOS = "CG";
	public static final String FLAG_TIPO_FLEXION_GRAFICOS = "FG";
	
	public static final String INICIAL_SIGLA_TIPO_EQUIPO_DISPENSADOR = "D";
	public static final String INICIAL_SIGLA_TIPO_EQUIPO_DOSIFICADOR = "P";
	
	/*Envio de Mail*/
	public static final String PARA_SIST_MAIL_USER = "7";
	public static final String PARA_SIST_MAIL_PASSWORD = "8";
	public static final String PARA_SIST_MAIL_TRANSPORT_HOST = "9";
	public static final String PARA_SIST_MAIL_FROM = "10";
	public static final String PARA_SIST_MAIL_TIMEOUT = "21";
	
	public static final String SISTEMA_MAIL_TRANS_PROTOCOL = "mail.transport.protocol";
	public static final String SISTEMA_TRANS_PROTOCOL = "SMTP";
	public static final String SISTEMA_MAIL_TRANS_HOST = "mail.smtp.host";
	public static final String SISTEMA_MAIL_TRANS_AUTH = "mail.smtp.auth"; 
	public static final String SISTEMA_MAIL_CONN_TIMEOUT = "mail.smtp.connectiontimeout";
	public static final String SISTEMA_MAIL_TIMEOUT = "mail.smtp.timeout";
	
	/*Evaluar para ponerlos en tabla general en la BD*/
	public static final String ESTADO_LOTE_REGISTRADO = "REG";
	public static final String ESTADO_LOTE_EN_ESPERA = "EES";
	public static final String ESTADO_LOTE_CONFORME = "CON";
	public static final String ESTADO_LOTE_NO_CONFORME = "NCO";
	
	public static final String MODALIDAD_DIRECTO = "DIR";
	public static final String MODALIDAD_BOMBEADO = "BOM";
	public static final String MODALIDAD_LANZADO = "LAN";
	
	public static final String MODALIDAD_SAP_DIRECTO = "DIRECTO";
	public static final String MODALIDAD_SAP_BOMBEADO = "BOMBEADO";
	public static final String MODALIDAD_SAP_LANZADO = "LANZADO";
		
	public static final String LUGAR_OBRA = "O";
	public static final String LUGAR_PLANTA = "P";
	public static final String LUGAR_LABORATORIO = "L";
	
	//Tipo de ensayo de concreto fresco
	public static final String ASENTAMIENTO_OBRA = "ASO";
	public static final String ASENTAMIENTO_PLANTA = "ASP";
	public static final String ASENTAMIENTO_LABORATORIO = "ASL";
	public static final String TEMPERATURA_OBRA = "TEO";
	public static final String TEMPERATURA_PLANTA = "TEP";
	public static final String TEMPERATURA_LABORATORIO = "TEL";
	public static final String FLUJO_ASENTAMIENTO_OBRA = "FLO";
	public static final String FLUJO_ASENTAMIENTO_PLANTA = "FLP";
	public static final String FLUJO_ASENTAMIENTO_LABORATORIO = "FLL";
	public static final String PESO_UNITARIO = "PEU";
	public static final String RENDIMIENTO_RELATIVO = "RER";
	public static final String CONTENIDO_AIRE = "COA";
	
	//Tipo de ensayo de concreto endurecido
	public static final String EDAD_1 = "R01";
	public static final String EDAD_3 = "R03";
	public static final String EDAD_7 = "R07";
	public static final String EDAD_14 = "R14";
	public static final String EDAD_21 = "R21";
	public static final String EDAD_28 = "R28";
	public static final String EDAD_54 = "R54";
	public static final String EDAD_90 = "R90";
	
	//Parametros de comparacion
	public static final String PARAMETRO_BARRERA = "BAR";
	public static final String PARAMETRO_CONTROL = "CON";
	public static final String PARAMETRO_REQUISITO = "REQ";
	
	public static final String TIPO_MANUAL = "M";
	public static final String TIPO_AUTOMATICO = "A";
	
	public static final String GRUPO_TIPO_ENSAYO_INP = "INP";
	public static final String GRUPO_TIPO_ENSAYO_FRESCO = "COF";
	public static final String GRUPO_TIPO_ENSAYO_ENDURECIDO = "COE";
	public static final String GRUPO_TIPO_ENSAYO_INGRESO_CURADO = "INC";
	
	public static final String CATEGORIA_TIPO_ENSAYO_OPT = "OPT";
	public static final String CATEGORIA_TIPO_ENSAYO_FIS = "FIS";
	
	public static final String PROCESO_TIPO_ELABORACION = "EC";
	public static final String PROCESO_TIPO_TRANSPORTE_Y_SUMINISTRO = "TS";
	
	//Constantes Inspeccion planta
	public static final String ESTADO_TRAT_INICIAL_REPROCESAR = "REP";
	public static final String ESTADO_TRAT_INICIAL_ELIMINAR = "ELI";
	
	public static final String ESTADO_TRAT_FINAL_REPROCESADO = "REPRO";
	public static final String ESTADO_TRAT_FINAL_REPRO_ELIM = "REPEL";
	
	public static final String ENSAYO_SEMAFORO_CONFORME_INP_PLANTA = "CON";
	public static final String ENSAYO_SEMAFORO_NO_CONFORME_INP_PLANTA = "NOC";
	public static final String ENSAYO_SEMAFORO_PLANIFICADO_INP_PLANTA = "PLN";
	public static final String ENSAYO_SEMAFORO_CONFIRMADO_PARCIAL_INP_PLANTA = "CNP";
	
	public static final String ESTADO_INI_FIN_CONFORME = "CON";
	public static final String ESTADO_INI_FIN_NO_CONFORME = "NOC";

	//Constantes Estado de Ensayo
	public static final String ESTADO_ENSAYO_CONFIRMADO = "CNF";
	public static final String ESTADO_ENSAYO_PLANIFICADO = "PLN";
	public static final String ESTADO_ENSAYO_CONFIRMADO_PARCIAL = "CNP";
	
	public static final String ESTADO_ENSAYO_REGISTRADO = "REG";
	
	public static final String UNIDAD_MET = "MET";
	
	public static final String UNI_MEZCLA_APROB = "Aprobado";
	public static final String UNI_MEZCLA_NO_APT = "No Apto";
	
	public static final String FLAG_CLIENTE = "1";
	public static final String FLAG_CONTRATISTA = "2";
	public static final String FLAG_AMBOS = "3";
	
	public static final String INDICADOR_LOTE = "L";
	public static final String INDICADOR_MUESTRA_INDIVIDUAL = "M";
	
	public static final long FLAG_CERTIFICADO_ENVIADO_MANUAL_REALIZADO = 1;
	public static final long FLAG_CERTIFICADO_ENVIADO_MANUAL_NO_REALIZADO = 0;
	public static final long FLAG_CERTIFICADO_ENVIADO_AUTOMATICO_REALIZADO = 1;
	public static final long FLAG_CERTIFICADO_ENVIADO_AUTOMATICO_NO_REALIZADO = 0;
                
	public static class TablaGeneral {
		public static final String TABLA_GENERAL_EST_ENSAYO_CON_FRES_ENDU = "CON_ESTENSACFE";
		public static final String TABLA_GENERAL_EST_TRAT_CON_FRES_ENDU = "CON_ESTTRATCFE";
		public static final String TABLA_GENERAL_EST_COM_CON_FRES_ENDU = "CON_ESTCOMCFE";
		public static final String TABLA_GENERAL_EST_INP_PLANTA_INI_FIN = "CON_ESTIPINIFIN";
		public static final String TABLA_GENERAL_EST_TRAT_INI_INP_PLANTA = "CON_ESTTRATINIIP";
		public static final String TABLA_GENERAL_EST_TRAT_FIN_INP_PLANTA = "CON_ESTTRATFINIP";
		public static final String TABLA_GENERAL_LUGAR_MUESTRA = "CON_LUGARMUES";
		public static final String TABLA_GENERAL_UNI_MED_LOTE = "UNMELO";
//		public static final String TABLA_GENERAL_ROLES_ENVIO_PENDIENTES_ING_CURADO = "GESAC_MAE_ROL";
		public static final String TABLA_GENERAL_RESPONSABLES_ENVIO_PENDIENTES_ING_CURADO = "GESAC_MAE_RESP";
		public static final String TABLA_GENERAL_RESPONSABLES_DEST_CORREO = "CORREO_DEST";
		public static final String TABLA_GENERAL_EST_LOTE = "STSLOT";
		public static final String TABLA_GENERAL_EST_LOTE_CONCRETO = "STSLOTCONCRE";
		public static final String TABLA_GENERAL_TIPO_PRODUCTO = "TIPPRO";
		
		public static final String SEXO = "SEXO";
		public static final String ESTADOCIVIL = "ESTADOCIVIL";
		public static final String TIPOCLIENTE = "TIPOCLIENTE";
		public static final String TIPOPRODUCTO = "TIPOPRODUCTO";
	
	}
	
	public static class NombreSecuencia {
		public static final String NOMBRE_SECUENCIA_MUESTRA_ALEATORIA = "SEC_MUES_ALEA";
		public static final String NOMBRE_SECUENCIA_ENSAYO = "SEC_ENSA";
	
	}
	
	public static class IngresoCurado {
		/*Evaluar para ponerlos en tabla general en la BD*/
		public static final String ESTADO_REGISTRADO = "REG";
		public static final String ESTADO_INGRESO_A_CURADO_A_TIEMPO = "INC";
		public static final String ESTADO_INGRESO_A_CURADO_FUERA_DE_TIEMPO = "ICF";
		public static final String ESTADO_PENDIENTE_INGRESO_A_CURADO = "PIC";
		
	}
	
	public static class Fechas {
		/*Constantes de formatos de fechas*/
		public static final String FORMATO_dd_MM_yyyy = "dd/MM/yyyy";
		public static final String FORMATO_yyyy__MM__dd = "yyyy-MM-dd";
		public static final String FORMATO_yyyy = "yyyy";
		public static final String FORMATO_dd_MM_yyyy_HH_mm = "dd/MM/yyyy HH:mm";
//		public static final String FORMATO_ddMMyyyy_HH_mm = "ddMMyyyy HH:mm";
		public static final String FORMATO_ddMMyyyy_HH_mm = "ddMMyyyy_HH_mm";
		public static final String FORMATO_ddMMyyyy_HH_GUION_mm = "ddMMyyyy_HH-mm";
		public static final String FORMATO_yyyy__MM__dd_T_HH_mm = "yyyy-MM-dd'T'HH:mm";
		public static final String FORMATO_HH_mm = "HH:mm";
		//Constantes de tiempo
		public static final long MILISEGUNDOS_POR_DIA = 24 * 60 * 60 * 1000; //Milisegundos en un dia 
		public static final long MILISEGUNDOS_POR_HORA = 60 * 60 * 1000; //Milisegundos en una hora
		public static final long MILISEGUNDOS_POR_MINUTO = 60 * 1000; //Milisegundos en un minuto
	}
		
	public static class Unidades {
		public static final String KILOGRAMOS_POR_CENTIMETRO_CUADRADO = "kg/cm2";
		public static final String KILOGRAMOS_POR_METRO_CUADRADO = "kg/m2";
		public static final String MEGA_PASCAL = "MPa";
		public static final String METRO_CUBICO = "m3";
		public static final String TONELADA = "TON";
		public static final String UNIDADES = "UNI";
	}
	
	public static class Sistema {
		//Key de propiedades del sistema
		public static final String KEY_PROPIEDAD_DIRECTORIO_TEMPORAL = "java.io.tmpdir";
		public static final String KEY_PROPIEDAD_SEPARADOR_RUTA = "file.separator";
	}
	
	public static class JasperReport {
		//Sufijos
		public static final String EXTENCION_PDF = ".pdf";
		public static final String EXTENCION_EXCEL = ".xls";
		public static final String EXTENCION_EXCEL_X = ".xlsx";
		
		public static final String PDF = "pdf";
		public static final String XLS = "xls";
		public static final String XLSX = "xlsx";
		
		public static final String MODO_REPORTE_PREVIEW = "PREVIEW";
		public static final String MODO_REPORTE_PDF = "PDF";
		public static final String MODO_REPORTE_EXCEL = "EXCEL";
		
		public static final String MODO_EXPORTACION_ATTACHMENT = "attachment";
		public static final String MODO_EXPORTACION_INLINE = "inline";
		
	}
	
	public static class Seguridad {
//		public static final Long VALOR_MINUTOS_MAXIMO_TIMEOUT = 60L;
		public static final String TIEMPO_ACTIVIDAD_ULTIMO = "tiempoActividadUltimo";
		public static final String MENSAJE_INFORMACION_LOGIN = "mensajeInformacionLogin";
		public static final String MENSAJE_INFORMACION_LOGIN_SESION_EXPIRADA = "Su sesi\u00f3n ha expirado";
		public static final String MENSAJE_INFORMACION_LOGIN_SESION_REQUERIDA = "Debe iniciar sesi\u00f3n";
		public static final String MENSAJE_ES_SESION_EXPIRADA = "esSesionExpirada";
	}
	
	public static class Secuencia {
		public static final String SEC_MUES_INDI = "SEC_MUES_INDI";
		public static final String SEC_MUES_ALEA = "SEC_MUES_ALEA";
		public static final String SEC_ENSA_FRES = "SEC_ENSA_FRES";
		public static final String SEC_ENSA_COMPRE = "SEC_ENSA_COMPRE";
		public static final String SEC_ENSA_FLEX = "SEC_ENSA_FLEX";
		public static final String SEC_LOTE = "SEC_LOTE";
		
	}
	
	public static class ParametrosSistema {
//		public static final Long COD_ISO_CERTIFICADO_CONCRETO_ID = 48L;
		public static final String COD_ISO_CERTIFICADO_CONCRETO_COD = "COD_ISO_CERTIFICADO_CALIDAD_CONCRETO";
		public static final String COD_ISO_CARTA_CONTROL_CONCRETO_COD = "COD_ISO_CARTA_CONTROL_CONCRETO";
		public static final Long SISTEMA_HORA_INICIO_ACTIVIDADES_ID = 17L;
		public static final String FACTOR_CONVERSION_MPA_COD = "FACTOR_CONV_MPA";
		public static final Long TIMEOUT_SESSION_ID = 11L;
	}
	
	public static class Equipo {
		public static final String SIGLA_EQUIPO_DISPENSADOR = "DISP";
	}
	
	public static class Sexo {
		public static final String MASCULINO = "M";
		public static final String FEMENINO = "F";
	}
	
	public static class TipoCliente {
		public static final String VIP = "VIP";
		public static final String PREMIUM = "PREM";
		public static final String GOLD = "GOLD";
		public static final String ONE = "ONE";
	}
	
	public static class EstadoCivil {
		public static final String SOLTERO = "S";
		public static final String CASADO = "C";
	}
	
	public static class TipoProducto {
		public static final String FINAL = "FIN";
		public static final String PROCESO = "PRO";
		public static final String MATERIA_PRIMA = "MAT";
	}
	
	public static class Rutas {
		
		/* Marco Benites 
		 * Comentar esto en Ambiente de Produccion (Ambiente de Produccion es Linux y Ambiente de Desarrollo es Windows)
		 ****************************************************************************************************************************/
		/*public static final String RUTA_LINUX_REPORTE_CARTA_CONTROL = "D:/SAC CONCRETO/Reportes/Carta Control/";
		public static final String RUTA_LINUX_REPORTE_CERTIFICADO_CALIDAD = "D:/SAC CONCRETO/Reportes/Certificado de Calidad/";
		public static final String RUTA_LINUX_REPORTE_INGRESO_CURADO = "D:/SAC CONCRETO//Reportes/Ingreso Curado/";
		public static final String RUTA_LINUX_REPORTE_GERENCIAL = "D:/SAC CONCRETO/Reportes/Reporte Gerencial/";
		*/
		/****************************************************************************************************************************/
		
		/* Marco Benites
		 * Comentar esto en Ambiente de Desarrollo (Ambiente de Produccion es Linux y Ambiente de Desarrollo es Windows)
		 ****************************************************************************************************************************/
		public static final String RUTA_LINUX_REPORTE_CARTA_CONTROL = "/home/SAC CONCRETO/Reportes/Carta Control/";
		public static final String RUTA_LINUX_REPORTE_CERTIFICADO_CALIDAD = "/home/SAC CONCRETO/Reportes/Certificado de Calidad/";
		public static final String RUTA_LINUX_REPORTE_INGRESO_CURADO = "/home/SAC CONCRETO/Reportes/Ingreso Curado/";
		public static final String RUTA_LINUX_REPORTE_GERENCIAL = "/home/SAC CONCRETO/Reportes/Reporte Gerencial/";
		
		/****************************************************************************************************************************/
		
		
		
		
	}
	
	public static class Plantas {
		
		public static final String SIGLA_PLANTA_CHIMBOTE = "CHI";
		public static final String SIGLA_PLANTA_TRUJILLO = "TRU";
		public static final String SIGLA_PLANTA_PACASMAYO = "PAC";
		public static final String SIGLA_PLANTA_CHICLAYO = "CIX";
		public static final String SIGLA_PLANTA_PIURA = "PIU";
		public static final String SIGLA_PLANTA_CAJAMARCA = "CAJ";
		public static final String SIGLA_PLANTA_JAEN = "JAE";
		
	}
	
}