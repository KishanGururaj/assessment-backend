package com.wolken.wolkenapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolken.wolkenapp.entity.CompanyEntity;
@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	public CompanyEntity findByUserName(String userName);
}
	
