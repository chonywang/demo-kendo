package pe.cpsaa.sac.concreto.util;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<Timestamp> {
	

	@Override
	public void serialize(Timestamp value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		DateFormat formatter = new SimpleDateFormat(Constantes.Fechas.FORMATO_yyyy__MM__dd);

		if(value!=null){
	    	jgen.writeString(formatter.format(value));
	    }
		
	}

}
