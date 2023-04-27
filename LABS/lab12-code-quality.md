:beginner: _**Lab 1:30 - 3:30**_  

:keyboard: **Code Quality : US11: New Admin Registration**  

:one: _Perform code quality using Sonar Lint_  
:two: _Write Junit test case for the validation_  
:three: _Perform code coverage using jacoco plugin_  
:four: _Sonarqube is optional_  
  

:loudspeaker: *Consider the requirements stated below which has been developed during our interim capstone.:*  

:point_right: As a New Administrator, I should be able to register myself to keep track and work on the sporting event systems database.
- An error message is displayed if all the details are not filled
- An error message is displayed if the email id is already in use by some other user
- An error message is displayed if the name contains numbers or special characters
Password should be a combination of at least an uppercase alphabet, lowercase alphabets, a digit, and a special character.
- An error message is displayed if the password entered by the customer is not in the expected format
- An error message is displayed if the phone number is already in use by some other user
- A new account is created if all the fields that have been entered by the user are proper.
- The user should be able to login with his/her emailId and password
Acceptance criteria
Given that I am an administrator,
When I select the option to register a new admin
And enter all the required details
Then I should be able to save the register the administrator