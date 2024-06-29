package com.ecommerce.sportcenter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.sportcenter.entity.Type;
import com.ecommerce.sportcenter.model.TypeResponse;
import com.ecommerce.sportcenter.repository.TypeRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
class TypeServiceImpl implements TypeService {

	private final TypeRepository typeRepository;

	public TypeServiceImpl(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	@Override
	public List<TypeResponse> getAllTypes() {
		log.info("Fetching All Types");
		List<Type> typeList = typeRepository.findAll();
		List<TypeResponse> typeResponses = typeList.stream().map(this::convertToTypeResponse)
				.collect(Collectors.toList());
		return typeResponses;
	}

	private TypeResponse convertToTypeResponse(Type type) {
		return TypeResponse.builder().id(type.getId()).name(type.getName()).build();
	}

}