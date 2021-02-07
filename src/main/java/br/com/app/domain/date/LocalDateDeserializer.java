package br.com.app.domain.date;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate>{

	@Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException, JsonProcessingException {
        
		String str = jsonParser.getText();
		
		return LocalDate.parse(str);
    }

	
}
