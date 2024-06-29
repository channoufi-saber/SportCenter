package com.ecommerce.sportcenter.service;

import java.util.List;

import com.ecommerce.sportcenter.model.ProductResponse;

public interface ProductService {

	ProductResponse getProductById(Integer productId);

	List<ProductResponse> getProducts();
}