package com.demo.service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entity.Registration;
import com.demo.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements  RegistrationService{

	//Dependency injection (spring framework creates the Repository internally
//	and injects the instance into the app
	@Autowired
	private RegistrationRepository registrationRepository;
//	POST:
//	http://localhost:9301/api/v2/registrations/register
	
//	{
//		   "adminName":"admin1",
//		   "email":"admin1@email.com",
//		   "phone":"1234554321",
//		   "password":"passtheword"
//		}
	@Override
	public Registration save(Registration registration) {
		//MessageDigest - provides functionality of a message digest algorithm ("MD5")
		// MessageDigests are secure one-way hash function that takes arbitrary sized data and 
//		produces a fixed-length hash value.
		
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			String plainTextPasswordString = registration.getPassword();
			byte[] passwordInBytes = plainTextPasswordString.getBytes();
			messageDigest.update(passwordInBytes);
			byte[] resultByteArray = messageDigest.digest();
			StringBuilder stringBuilder = new StringBuilder();
			for(byte byteVar : resultByteArray) {
				String formattedString = String.format("%02x",byteVar);
				stringBuilder.append(formattedString);
			}
			String hashedPassword = stringBuilder.toString();
			registration.setPassword(hashedPassword);
		} catch (NoSuchAlgorithmException e) {
		System.out.println("No Such Algorithm :  " + e);
		// rethrowing the exception
		throw new RuntimeException(e);
		
		}
		// Persist the entity
		Registration savedRegistration = registrationRepository.save(registration);
		return savedRegistration;
	}

	@Override
	public Registration findByEmail(String email) {
		return null;
	}

	@Override
	public Registration findByEmailAndPassword(String email, String hashedPassword) {
		Registration registration = registrationRepository.findByEmailAndPassword(email, hashedPassword);
		return registration;
	}

	@Override
	public Boolean isValidUser(String email, String password) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			byte[] passwordInBytes = password.getBytes();
			messageDigest.update(passwordInBytes);
			byte[] resultByteArray = messageDigest.digest();
			StringBuilder stringBuilder = new StringBuilder();
			for(byte byteVar : resultByteArray) {
				String formattedString = String.format("%02x",byteVar);
				stringBuilder.append(formattedString);
			}
//			The entered hashed password
			String hashedPassword = stringBuilder.toString();
			Registration registration = findByEmailAndPassword(email, hashedPassword);
			if(registration != null) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
		System.out.println("No Such Algorithm :  " + e);
		// rethrowing the exception
		throw new RuntimeException(e);
		
		}
		return false;
	}
}
