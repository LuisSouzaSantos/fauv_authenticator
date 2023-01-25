//package com.fauv.authenticator.security.filter;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fauv.authenticator.utils.Utils;
//
//@Component
//public class SanitazeRequestFilter implements Filter {
//
//	//Filter to sanitaze the request
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		
//		String sanitazedJson = sanitazeRequestBody(httpRequest);
//				
//		chain.doFilter(request, response);
//	}
//	
//	private String sanitazeRequestBody(HttpServletRequest request) throws IOException {
//		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//		
//		Map<String,Object> sanitazedJson = sanitazeJson(body);
//		
//		return new ObjectMapper().writeValueAsString(sanitazedJson);
//	}
//	
//	private Map<String,Object> sanitazeJson(String probablyJson) throws JsonMappingException, JsonProcessingException {
//		@SuppressWarnings("unchecked")
//		Map<String,Object> jsonToBeSanitaze = new ObjectMapper().readValue(probablyJson, Map.class);
//		Map<String,Object> sanitazedJson = new HashMap<>(); 
//		
//		//Performing sanitaze
//		for (Map.Entry<String, Object> element : jsonToBeSanitaze.entrySet()) {
//			Object value = element.getValue();
//			
//			if (value instanceof String) {
//				String newValue = sanitazeStringValue((String) value);
//				
//				value = (Object) newValue;
//			}
//			
//			sanitazedJson.put(element.getKey(), value);
//		}
//		
//		return sanitazedJson;
//	}
//	
//	private String sanitazeStringValue(String value) {
//		return Utils.removeAllUnecessaryBlankSpaces(value);
//	}
//	
//
//}
