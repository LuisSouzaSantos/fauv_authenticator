package com.fauv.authenticator.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fauv.authenticator.entity.PathAuthentication;
import com.fauv.authenticator.security.enums.PathAuthenticationType;

public class Controller {

	public static List<PathAuthentication>  apisGet() {
		return Stream.of(AuthenticationController.APIS_GET, TokenController.APIS_GET).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static List<PathAuthentication> apisPost() {
		return Stream.of(AuthenticationController.APIS_POST, TokenController.APIS_POST).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static List<PathAuthentication> apisPut() {
		return Stream.of(AuthenticationController.APIS_PUT, TokenController.APIS_PUT).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static List<PathAuthentication> apisDelete() {
		return Stream.of(AuthenticationController.APIS_DELETE, TokenController.APIS_DELETE).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static String[] geApisGetOpened() {
		return apisGet().stream()
				.filter(path -> path.getPathAuthenticationType().equals(PathAuthenticationType.NO_AUTHENTICATION_NEEDED))
				.map(path -> path.getPath())
				.toArray(String[]::new);
	}
	
	public static String[] getApisPostOpened(){
		return apisPost().stream()
				.filter(path -> path.getPathAuthenticationType().equals(PathAuthenticationType.NO_AUTHENTICATION_NEEDED))
				.map(path -> path.getPath())
				.toArray(String[]::new);
	}
	
	public static String[] getApisPutOpened(){
		return apisPut().stream()
				.filter(path -> path.getPathAuthenticationType().equals(PathAuthenticationType.NO_AUTHENTICATION_NEEDED))
				.map(path -> path.getPath())
				.toArray(String[]::new);
	}
	
	public static String[] getApisDeleteOpened(){
		return apisDelete().stream()
				.filter(path -> path.getPathAuthenticationType().equals(PathAuthenticationType.NO_AUTHENTICATION_NEEDED))
				.map(path -> path.getPath())
				.toArray(String[]::new);
	}
		
}