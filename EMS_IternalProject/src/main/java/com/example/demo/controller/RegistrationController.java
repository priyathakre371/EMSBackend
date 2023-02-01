package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Registration;
import com.example.demo.serviceimpl.RegistrationServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/register")
public class RegistrationController {

	
	@Autowired
	RegistrationServiceImpl regService;
	
	
	
	
	@PostMapping("/loginuser")  
	   public String loginUser(@RequestBody Registration r) throws Exception
	   {
		System.out.println(r.getUsername()+" "+r.getPassword());
	       String username=r.getUsername();
	       String password=r.getPassword();
	       
	       Registration regobj =null;
	       String status="";
	       System.out.println(username +" "+password);
	       
	       if(username !=null && password !=null)
	       {
	           regobj =regService.findByUsernameAndPassword(username,password);
	       }
	       
	       if(regobj==null) {
	    	  // return regobj;
	    	   status="Not login";
	    	 
	       }
	       else if(regobj.getUsername().equals(username) && regobj.getPassword().equals(password) ) {
	    	  // System.out.println(regobj+" login is not successfull");
	    	   status= "login successfully";
	       }
		return status;
	       
	           //return r;
	           
	           
	   }
	   
	
	
	@GetMapping("/getAllData")
	public Iterable<Registration> getAllData()
	{
		
		 Iterable<Registration> em=regService.getAllData();
		
		return em;
	}
	
	
	 @GetMapping("/loginBy/{username}/{password}")
	 public Registration loginUsernamePassword(@PathVariable("username") String username,@PathVariable("password") String password)
	 {
		 Registration ee= new Registration();
		 
		 Registration emp= regService.findByUsernameAndPassword(username,password);
		 				
		 ee.setUsername(username);
		 ee.setPassword(password);
		 return ee;	 
	 }
	 @PostMapping("/saveData")
	 public ResponseEntity<String> saveData(@RequestBody Registration reg)
	 {
		 
		 regService.saveData(reg);
		 
		 
		 return new ResponseEntity<String>("Your Data Is Save",HttpStatus.OK);
		 
	 }
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
