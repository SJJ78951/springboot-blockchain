package com.sjj.springboot.util;

public class ObjectMapperUtil {
	private static ObjectMapperConfig mapper = new ObjectMapperConfig();

	public static ObjectMapperConfig getJsonMapper() {
		return mapper;
	}
}
