package com.sjj.springboot.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class ObjectMapperConfig extends ObjectMapper {

	private static final long serialVersionUID = -7122744384858902907L;

	public ObjectMapperConfig() {
		super();
		this.setSerializationInclusion(Include.NON_NULL);
		this.configure(Feature.ALLOW_SINGLE_QUOTES, true) ;
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	}
}