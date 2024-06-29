package com.ecommerce.sportcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.sportcenter.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

}