package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.proxy.RegistrationProxy;


//package com.demo.service;
//
//public interface RegistrationService {
//public String getServiceInstance();
//}


@Service
//public class RegistrationServiceImpl implements RegistrationService{
public class RegistrationService{

	@Autowired
	private RegistrationProxy registrationProxy;

	public String getServiceInstance() {
	String serverInstancePortString = registrationProxy.getServiceInstance();
	return serverInstancePortString;
	}

}


