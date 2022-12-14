package com.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//Directly invoking a service instance
//@FeignClient(name="registration-service" , url = "http://localhost:9302")
@FeignClient(name="registration-service")
public interface RegistrationProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstance();
}