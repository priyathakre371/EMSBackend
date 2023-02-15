package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;
import com.example.demo.repo.RegistrationRepository;
import com.example.demo.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	RegistrationRepository regRepository;

	@Override
	public Registration findByUsernameAndPassword(String username, String password) {
		
	
		return regRepository.findByUsernameAndPassword(username, password);
		
	}

	@Override
	public Registration saveData(Registration reg) {
		// TODO Auto-generated method stub
		return regRepository.save(reg);
		
	}

	@Override
	public List<Registration> getAllData() {
		
		return regRepository.findAll();
	}

	@Override
	public Registration findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return regRepository.findByEmailAndPassword(email,password);
	}

	

}
