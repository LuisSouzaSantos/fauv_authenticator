package com.fauv.authenticator.service.impl;

import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fauv.authenticator.service.EntityModelMapper;

@Service
public class EntityModelMapperImpl implements EntityModelMapper {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public <T> T toEntity(T entity, Class<T> type) {
		if (entity == null) { return null; }
		
		return modelMapper.map(entity, type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Collection<T> toCollection(Collection<T> entity, Class<T> type) {
		if (entity == null) { return null; }
		
		return (Collection<T>) modelMapper.map(entity, type);
	}

}
