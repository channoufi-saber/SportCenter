package com.ecommerce.sportcenter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.sportcenter.entity.Brand;
import com.ecommerce.sportcenter.model.BrandResponse;
import com.ecommerce.sportcenter.repository.BrandRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService {

	private final BrandRepository brandRepository;

	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<BrandResponse> getAllBrands() {
		log.info("Fetching All Brands!!!");
		List<Brand> brandList = brandRepository.findAll();
		List<BrandResponse> brandResponses = brandList.stream().map(this::convertToBrandResponse)
				.collect(Collectors.toList());
		log.info("Fetched All Brands!!!");
		return brandResponses;
	}

	private BrandResponse convertToBrandResponse(Brand brand) {
		return BrandResponse.builder().id(brand.getId()).name(brand.getName()).build();
	}

}