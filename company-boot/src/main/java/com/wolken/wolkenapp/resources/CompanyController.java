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
		try {
			logger.info("inside try block inside save method inside resources");
			return companyService.save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("inside catch block inside save method inside resources");
			e.printStackTrace();
		}
		logger.error(" returning null inside save method inside resources");
		return null;
		
	}
	@PutMapping("/update/{id}")
	@CrossOrigin
	public String updateByUserName(@PathVariable int id ,@RequestBody CompanyEntity entity) {
		logger.info("inside update by user name inside resources");
		try {
			logger.info("inside try block inside update by user name inside resources");
			return companyService.updateByUserName(id,entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("inside catch block inside update by user name inside resources");
			e.printStackTrace();
		}
		logger.error(" returning null inside update by user name inside resources");
		return null;
		
	}
	
	@GetMapping("/searchid/{id}")
	@CrossOrigin
	public CompanyEntity searchId(@PathVariable int id){
		logger.info("inside search id inside resources");
		try {
			logger.info("inside try block inside search id inside resources");
			return companyService.validateAndSearch(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("inside catch block inside search id inside resources");
			e.printStackTrace();
		}
		logger.info("returning null inside search id inside resources");
		return null;
	}
	
	@GetMapping("/delete/{userName}")
	@CrossOrigin
	@Transactional
	public Iterable<CompanyEntity> deleteUser(@PathVariable String userName){
		logger.info("inside delete inside resources");
		return companyService.validateAndDeleteByUserName(userName);
	}
	/*
	 * @DeleteMapping("/delete")
	 * 
	 * @CrossOrigin
	 * 
	 * @Transactional public String deleteByUserName(@RequestBody CompanyEntity
	 * entity) { logger.info("delete by team name inside resources"); return
	 * companyService.validateAndDeleteByUserName(entity);
	 * 
	 * }
	 */
	

}
