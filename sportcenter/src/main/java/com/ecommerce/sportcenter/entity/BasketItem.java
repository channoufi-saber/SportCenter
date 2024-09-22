package com.ecommerce.sportcenter.entity;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@RedisHash("BasketItem")
public class BasketItem {

	@Id
	private Integer id;
	private String name;
	private String description;
	private Long price;
	private String pictureUrl;
	private String productBrand;
	private String productType;
	private Integer quantity;

}