:one: _Use the Virtual Lerning System LAB ASSIGNMENT_  
:two: _Create two microservices Login and Courses Microservices_
:three: _Register them in Eureka server_  
:four: _Complete the Registration Microservice_  
:five: _Implement hashing of password in the service layer_  
:six: _Use Postman to register_ 
:six: _Perform the logic to validate the user_ 
:seven: _Modify the below method_ 
1. It shoud accept the registration object and perform the validation
2. The Registration object should be posted from postman. 
```java
    @GetMapping("/registrations/{email}/{password}")
    public Boolean authenticate(@PathVariable(value="email") String email,  @PathVariable(value="password") String password) {
    	Boolean authenticatedBoolean = registrationService.isValidUser(email, password);
    	System.out.println("REgistration Controller - authenticate : " + authenticatedBoolean);
    	return authenticatedBoolean;
    }
```
:eight: _Perfom client side load balancing with multiple microservices_  
:nine: _Create a client service, fetch the course details and display them on the browser / postman_  
:one::zero: _Implement the API gateway and fetch course details uisng API Gateway with load balancing_  
