package com.fauv.authenticator.service;

import java.util.Collection;

public interface EntityModelMapper {

	public <T> T toEntity(T entity, Class<T> type);
	
	public <T> Collection<T> toCollection(Collection<T> entity, Class<T> type);
		
}
