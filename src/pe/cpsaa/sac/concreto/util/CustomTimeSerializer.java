package pe.cpsaa.sac.concreto.util;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomTimeSerializer extends JsonSerializer<Time> {
	

	@Override
	public void serialize(Time value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		DateFormat formatter = new SimpleDateFormat(Constantes.Fechas.FORMATO_HH_mm);

		if(value!=null){
	    	jgen.writeString(formatter.format(value));
	    }
		
	}



}
