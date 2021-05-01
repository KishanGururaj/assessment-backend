package com.wolken.wolkenapp.services;

import java.util.List;

import com.wolken.wolkenapp.entity.CompanyEntity;

public interface CompanyService {

	public List<CompanyEntity> getAll();

	public String save(CompanyEntity entity);

	public String updateByUserName(CompanyEntity entity);

	public String validateAndDeleteByUserName(CompanyEntity entity);

}
