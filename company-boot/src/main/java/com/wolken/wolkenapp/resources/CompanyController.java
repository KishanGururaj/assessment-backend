package com.wolken.wolkenapp.resources;

import java.util.List;

import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.entity.CompanyEntity;
import com.wolken.wolkenapp.services.CompanyService;

@RestController
@RequestMapping("/")
public class CompanyController {
	@Autowired
	CompanyService companyService;
	Logger logger= Logger.getLogger("CompanyController");
	@GetMapping("getAll")
	@CrossOrigin
	public List<CompanyEntity>getAll(){
		logger.info("inside getAll inside Company controller");
		return companyService.getAll();
		
	}
	@PostMapping("/save")
	@CrossOrigin
	@Transactional
	public String save(@RequestBody CompanyEntity entity) {
		logger.info("inside save method inside resources");
		return companyService.save(entity);
		
	}
	@PutMapping("/update")
	@CrossOrigin
	public String updateByUserName(@RequestBody CompanyEntity entity) {
		logger.info("inside update by user name inside resources");
		return companyService.updateByUserName(entity);
		
	}
	@DeleteMapping("/delete")
	@CrossOrigin
	@Transactional
	public String deleteByUserName(@RequestBody CompanyEntity entity) {
		logger.info("delete by team name inside resources");
		return companyService.validateAndDeleteByUserName(entity);
		
	}
	

}
