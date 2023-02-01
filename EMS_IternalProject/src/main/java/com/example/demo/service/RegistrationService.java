package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Registration;

public interface RegistrationService {

	public Registration findByUsernameAndPassword(String username, String password);

	public void saveData(Registration reg);

	public Iterable<Registration> getAllData();

	public Registration findByEmailAndPassword(String email, String password);

}
