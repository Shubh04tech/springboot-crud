# TODO List for Adding Website with Authentication

- [x] Update pom.xml to add Thymeleaf, Spring Security, and Validation dependencies
- [x] Update UserRepository.java to add findByEmail method
- [x] Update UserService.java to add findByEmail method
- [x] Update UserServiceImpl.java to implement findByEmail, fix createUser bug, and add password encoding
- [x] Create AuthController.java for handling web page requests and form submissions
- [x] Create SecurityConfig.java for Spring Security configuration
- [x] Create register.html Thymeleaf template
- [x] Create login.html Thymeleaf template
- [x] Create profile.html Thymeleaf template
- [x] Create home.html Thymeleaf template
- [x] Create CSS file for styling in static folder
- [x] Update application.properties for any additional configurations
- [x] Test the complete flow: register -> login -> profile -> logout
