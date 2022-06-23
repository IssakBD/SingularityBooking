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
public class Rooms {
    @Id
    public Long id;
    public Long roomNumber;
}
