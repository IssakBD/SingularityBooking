package kz.arab.SingularityHackathon.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private boolean roleIsAdmin;
}
