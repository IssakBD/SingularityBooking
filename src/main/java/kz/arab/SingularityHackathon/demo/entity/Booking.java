package kz.arab.SingularityHackathon.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    private Long id;
    private Long userId;
    private Long timeSlotId;
    private Date date;
    private boolean roleIsAdmin;
}
