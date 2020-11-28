package br.com.app.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJson{

	public String objectToString(Object obj) {

		ObjectMapper mapper = new ObjectMapper( );
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			 
			e.printStackTrace();
		}
		return "";

	}
	
	public Object jsonToObject(String json, Class<?> clas){
		
		ObjectMapper mapper = new ObjectMapper( );
		
		try {
			return mapper.readValue(json,clas);

		} catch (IOException e) {
			 
			e.printStackTrace();
		} 
		return null;
	}
	
	public List<Object> jsonToListObject(String json, Class<?> clas) {
		
		ObjectMapper mapper = new ObjectMapper( );
		
		 try {
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clas));
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		 return Collections.emptyList();
	}
	
}
