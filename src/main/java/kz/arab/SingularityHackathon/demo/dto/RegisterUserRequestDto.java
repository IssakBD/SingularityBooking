package kz.arab.SingularityHackathon.demo.dto;

import lombok.Data;

@Data
public class RegisterUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
