package kz.arab.SingularityHackathon.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class Booking {
    private Long id;
    private Long userId;
    private Long timeSlotId;
    private Date date;
    private boolean roleIsAdmin;
}
