package pe.cpsaa.sac.concreto.util;

import java.util.ArrayList;
import java.util.List;

import pe.cpsaa.sac.concreto.domain.model.TablaGeneral;

public class TablaGeneralUtil {
	
	public static List<TablaGeneral> obtenerConstantesCombo(String tabla){
		List<TablaGeneral> lista = new ArrayList<TablaGeneral>();
		if(Constantes.TablaGeneral.SEXO.equals(tabla)){
			lista = obtenerSexo();
		}else if(Constantes.TablaGeneral.ESTADOCIVIL.equals(tabla)){
			lista = obtenerEstadoCivil();
		}else if(Constantes.TablaGeneral.TIPOCLIENTE.equals(tabla)){
			lista = obtenerTipoCliente();
		}else if(Constantes.TablaGeneral.TIPOPRODUCTO.equals(tabla)){
			lista = obtenerTipoProducto();
		}
		return lista;
	}
	
	public static List<TablaGeneral> obtenerSexo(){
		List<TablaGeneral> lista = new ArrayList<TablaGeneral>();
		lista.add(new TablaGeneral(Constantes.Sexo.MASCULINO, "Masculino"));
		lista.add(new TablaGeneral(Constantes.Sexo.FEMENINO, "Femenino"));
		return lista;
	}
	
	public static List<TablaGeneral> obtenerTipoCliente(){
		List<TablaGeneral> lista = new ArrayList<TablaGeneral>();
		lista.add(new TablaGeneral(Constantes.TipoCliente.VIP, "VIP"));
		lista.add(new TablaGeneral(Constantes.TipoCliente.GOLD, "GOLD"));
		lista.add(new TablaGeneral(Constantes.TipoCliente.PREMIUM, "PREMIUM"));
		lista.add(new TablaGeneral(Constantes.TipoCliente.ONE, "ONE"));
		return lista;
	}
	
	public static List<TablaGeneral> obtenerEstadoCivil(){
		List<TablaGeneral> lista = new ArrayList<TablaGeneral>();
		lista.add(new TablaGeneral(Constantes.EstadoCivil.SOLTERO, "Soltero"));
		lista.add(new TablaGeneral(Constantes.EstadoCivil.CASADO, "Casado"));
		return lista;
	}
	
	public static List<TablaGeneral> obtenerTipoProducto(){
		List<TablaGeneral> lista = new ArrayList<TablaGeneral>();
		lista.add(new TablaGeneral(Constantes.TipoProducto.MATERIA_PRIMA, "Materia Prima"));
		lista.add(new TablaGeneral(Constantes.TipoProducto.PROCESO, "Proceso"));
		lista.add(new TablaGeneral(Constantes.TipoProducto.FINAL, "Final"));
		return lista;
	}
	
}
