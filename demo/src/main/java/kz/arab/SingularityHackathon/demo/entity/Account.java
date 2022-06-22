package kz.arab.SingularityHackathon.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Account {
    @Id
    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private Enum role;
}
