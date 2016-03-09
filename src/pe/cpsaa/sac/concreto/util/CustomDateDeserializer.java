package pe.cpsaa.sac.concreto.util;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {
	
	Logger logger = Logger.getLogger(CustomDateDeserializer.class);

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		
		Date date = null;
		
		try {
            String fechaJson = null;
            
            if(jsonParser != null)
            	fechaJson = jsonParser.getText();
            
            SimpleDateFormat sdf_dd_MM_yyyy = new SimpleDateFormat(Constantes.Fechas.FORMATO_dd_MM_yyyy);
            
            logger.info("fechaJson: " + fechaJson);
            
            if(fechaJson!=null && fechaJson.trim().length()>0){
            	date = new Date(sdf_dd_MM_yyyy.parse(fechaJson).getTime());
            }
            
            
            logger.info("Actual TimeStamp deserializado: " + date);
            
        } catch (Exception e) {
            logger.error("Fallo al parsear fecha: "+jsonParser.getText());
            e.printStackTrace();
            throw new IOException("Fallo al parsear fecha: "+jsonParser.getText());
        }
		
		return date;
		
	}

}
