package com.acn.lkm.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
	
	public static <T> T convertJsonToObject(String json, Class<T> var) throws IOException {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.readValue(json, var); 
	}

}
