package pe.cpsaa.sac.concreto.util;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomSqlTimeSerializer extends JsonSerializer<Time>{

	@Override
	public void serialize(Time value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat(Constantes.Fechas.FORMATO_HH_mm);

		if(value!=null){
			Date hora = new Date(value.getTime());
			
		    jgen.writeString(formatter.format(hora));
		}
		
	}

}
