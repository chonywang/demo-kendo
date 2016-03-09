package pe.cpsaa.sac.concreto.util;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomTimeDeserializer extends JsonDeserializer<Time> {
	
	Logger logger = Logger.getLogger(CustomTimeDeserializer.class);

	@Override
	public Time deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		
		Time time = null;
		
		try {
            String fechaJson = jsonParser.getText();
            
            SimpleDateFormat sdf_HH_mm = new SimpleDateFormat(Constantes.Fechas.FORMATO_HH_mm);
            
            logger.info("fechaJson: " + fechaJson);
            
            if(fechaJson!=null && fechaJson.trim().length()>0){
            	time = new Time(sdf_HH_mm.parse(fechaJson).getTime());
            }
            
            
            logger.info("Actual Time deserializado: " + time);
            
        } catch (Exception e) {
            logger.error("Fallo al parsear fecha: "+jsonParser.getText());
            e.printStackTrace();
            throw new IOException("Fallo al parsear fecha: "+jsonParser.getText());
        }
		
		return time;
		
	}

}
