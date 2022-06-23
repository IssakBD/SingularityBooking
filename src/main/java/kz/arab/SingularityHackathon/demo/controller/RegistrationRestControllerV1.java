package kz.arab.SingularityHackathon.demo.controller;

import kz.arab.SingularityHackathon.demo.dto.RegisterUserRequestDto;
import kz.arab.SingularityHackathon.demo.entity.Status;
import kz.arab.SingularityHackathon.demo.entity.User;
import kz.arab.SingularityHackathon.demo.repository.UserRepository;
import kz.arab.SingularityHackathon.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/register")

public class RegistrationRestControllerV1 {
    private final UserService userService;

    @Autowired
    public RegistrationRestControllerV1(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @Transactional
    @CrossOrigin("*")
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
                userService.save(user);
                userService.setRole(user.getId());
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
