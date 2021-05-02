package com.wolken.wolkenapp.services;

import java.util.List;
import java.util.Optional;

import com.wolken.wolkenapp.entity.CompanyEntity;

public interface CompanyService {

	public List<CompanyEntity> getAll();

	public String save(CompanyEntity entity) throws Exception;

	public String updateByUserName(int id,CompanyEntity entity) throws Exception;

	public Iterable<CompanyEntity> validateAndDeleteByUserName(String username);

	public CompanyEntity validateAndSearch(int id) throws Exception;

	
	
}
