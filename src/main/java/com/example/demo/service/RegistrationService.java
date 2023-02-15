package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Registration;

public interface RegistrationService {

	public Registration findByUsernameAndPassword(String username, String password);

	public Registration saveData(Registration reg);

	public List<Registration> getAllData();

	public Registration findByEmailAndPassword(String email, String password);

}
