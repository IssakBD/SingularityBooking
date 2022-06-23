package kz.arab.SingularityHackathon.demo.controller;

import kz.arab.SingularityHackathon.demo.dto.RegisterUserRequestDto;
import kz.arab.SingularityHackathon.demo.entity.Status;
import kz.arab.SingularityHackathon.demo.entity.User;
import kz.arab.SingularityHackathon.demo.repository.UserRepository;
import kz.arab.SingularityHackathon.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/register")
public class RegistrationRestControllerV1 {

    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public RegistrationRestControllerV1(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody RegisterUserRequestDto registerUserRequestDto){
        User user = new User();
            String firstName = registerUserRequestDto.getFirstName();
            String lastName = registerUserRequestDto.getLastName();
            String email = registerUserRequestDto.getEmail();
            String password = registerUserRequestDto.getPassword();

            user.setUsername(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setEmail(email);
            user.setCreated(new Date());
            user.setUpdated(new Date());
            user.setStatus(Status.ACTIVE);

            if(userService.findByUsername(email) == null) {
                userService.saveUserAndSetRole(user);
                return new ResponseEntity<String>(
                        "Registration is successful!",
                        HttpStatus.OK);
            }
            else{
                return new ResponseEntity<String>(
                        "Registration is NOT successful! This email already exists!",
                        HttpStatus.CONFLICT);
            }

    }
}
