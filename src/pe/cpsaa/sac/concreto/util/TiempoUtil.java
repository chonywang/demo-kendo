package pe.cpsaa.sac.concreto.util;

import java.util.ArrayList;
import java.util.List;

import com.kendoui.spring.models.DropDownListItem;

public class TiempoUtil {
	
	public static List<DropDownListItem> hora(){
		
		List<DropDownListItem> items= new ArrayList<DropDownListItem>();
		
		for(int i=0;i<24;i++){
			items.add(new DropDownListItem(TiempoUtil.CompletarTiempo( String.valueOf(i)), String.valueOf(i)));//TiempoUtil.CompletarTiempo(String.valueOf(i))));
		}
		return items;
	}	
	
	public static List<DropDownListItem> minuto(){
		
		List<DropDownListItem> items= new ArrayList<DropDownListItem>();
		
		for(int i=0;i<60;i++){
			items.add(new DropDownListItem(TiempoUtil.CompletarTiempo( String.valueOf(i)), String.valueOf(i)));//TiempoUtil.CompletarTiempo(String.valueOf(i))));
//			items.add(new DropDownListItem(TiempoUtil.CompletarTiempo( String.valueOf(i)), TiempoUtil.CompletarTiempo( String.valueOf(i))));//TiempoUtil.CompletarTiempo(String.valueOf(i))));
		}
		return items;
	}
	
	public static List<DropDownListItem> hora_HH(){
		
		List<DropDownListItem> items= new ArrayList<DropDownListItem>();
		
		for(int i=0;i<24;i++){
			items.add(new DropDownListItem(TiempoUtil.CompletarTiempo( String.valueOf(i)), TiempoUtil.CompletarTiempo( String.valueOf(i))));//TiempoUtil.CompletarTiempo(String.valueOf(i))));
		}
		return items;
	}	
	
	public static List<DropDownListItem> minuto_mm(){
		
		List<DropDownListItem> items= new ArrayList<DropDownListItem>();
		
		for(int i=0;i<60;i++){
			items.add(new DropDownListItem(TiempoUtil.CompletarTiempo( String.valueOf(i)), TiempoUtil.CompletarTiempo( String.valueOf(i))));//TiempoUtil.CompletarTiempo(String.valueOf(i))));
//			items.add(new DropDownListItem(TiempoUtil.CompletarTiempo( String.valueOf(i)), TiempoUtil.CompletarTiempo( String.valueOf(i))));//TiempoUtil.CompletarTiempo(String.valueOf(i))));
		}
		return items;
	}
	
	public static String CompletarTiempo(String cadena){
		int tam = cadena.length();
		if(tam < 2){
			cadena = "0"+cadena;
		}
		return cadena;
	}

}
