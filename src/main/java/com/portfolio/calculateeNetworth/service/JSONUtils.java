package com.portfolio.calculateeNetworth.service;

import java.io.StringReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
	public static <T> T convertToObject(String json, Class<T> t) {
		StringReader reader = new StringReader(json);
		ObjectMapper mapper = new ObjectMapper();
		try {
		    return mapper.readValue(reader, t);
		} catch (Exception e) {
//		    logger.error(e.getMessage(), e);
		}
		return null;
	    }
}
