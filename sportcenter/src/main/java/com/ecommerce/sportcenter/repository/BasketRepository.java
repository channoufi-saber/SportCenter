package com.ecommerce.sportcenter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportcenter.entity.Basket;

@Repository
public interface BasketRepository extends CrudRepository<Basket, String> {

}