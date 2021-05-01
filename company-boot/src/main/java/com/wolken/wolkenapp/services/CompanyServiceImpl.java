package com.wolken.wolkenapp.services;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.entity.CompanyEntity;
import com.wolken.wolkenapp.repository.CompanyRepository;
@Service
public class CompanyServiceImpl implements  CompanyService{
	@Autowired
	CompanyRepository repository;
	Logger logger=Logger.getLogger("CompanyServiceImpl");
	@Override
	public List<CompanyEntity> getAll() {
		// TODO Auto-generated method stub
		logger.info("get all inside service");
		return repository.findAll();
	}

	@Override
	public String save(CompanyEntity entity) {
		// TODO Auto-generated method stub
		logger.info("inside save method inside service ");
		if (entity != null) {
			logger.info("entity is not null inside save inside service ");
			repository.save(entity);
			return "Data Saved Successfully";
		} else {
			logger.error("entity is null inside save inside service");
			return "Data Saved Unsuccessfully";
		}

	}

	@Override
	public String updateByUserName(CompanyEntity entity) {
		// TODO Auto-generated method stub
		logger.info("inside update inside service");
		CompanyEntity obj = repository.findByUserName(entity.getUserName());
		obj.setFirstName(entity.getFirstName());
		obj.setLastName(entity.getLastName());
		obj.setEmailId(entity.getEmailId());
		obj.setPhoneNo(entity.getPhoneNo());
		obj.setPassword(entity.getPassword());
		obj.setConfirmPassword(entity.getConfirmPassword());
		if (obj != null &&entity!=null) {
			logger.info("obj is not null and entity is not null inside update inside service  ");
			repository.save(obj);
			return "Update Successfull";
		}
			logger.error("obj is null and entity is not null inside update inside service");
			return "Update Unsuccessfull";
		
	}

	@Override
	public String validateAndDeleteByUserName(CompanyEntity entity) {
		// TODO Auto-generated method stub
		
		logger.info("delete user name inside service ");
		CompanyEntity companyEntity = repository.findByUserName(entity.getUserName());
		System.out.println(companyEntity);
		if (companyEntity != null) {
			logger.info("entity is not null inside service");
			repository.delete(companyEntity);
			return "Delete SuccessFull";
		}
		logger.error("entity is null inside service");
		return "Delete UnsuccessFull";
		 
		
	}

}
