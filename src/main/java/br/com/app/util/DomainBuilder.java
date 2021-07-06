package br.com.app.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class DomainBuilder {

	private Logger logger = LoggerFactory.getLogger(DomainBuilder.class);
	private ObjectMapper objectMapper;

	public DomainBuilder() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.registerModule(new JavaTimeModule());
		this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		this.objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public <T> T builder(String json, Class<T> valueType) {

		try {
			return objectMapper.readValue(json, valueType);

		} catch (IOException e) {

			logger.error(e.getMessage());
		}

		return null;
	}

	public <T> List<T> collectionBuilder(String json, Class<T> valueType) {

		try {
			return objectMapper.readValue(json,
					objectMapper.getTypeFactory().constructCollectionType(List.class, valueType));
		} catch (IOException e) {

			logger.error(e.getMessage());
		}
		return Collections.emptyList();
	}

}
