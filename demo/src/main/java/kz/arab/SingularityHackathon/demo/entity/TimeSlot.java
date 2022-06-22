package kz.arab.SingularityHackathon.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "timeslots")
public class TimeSlot {
    @Id
    private Long id;
    private String timeSlot;
}
