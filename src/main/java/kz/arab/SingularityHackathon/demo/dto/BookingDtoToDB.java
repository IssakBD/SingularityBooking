package kz.arab.SingularityHackathon.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;


@Data
@AllArgsConstructor
public class BookingDtoToDB {
    private Long userId;
    private Long timeSlotId;
    private Date date;
    private Long roomId;
    private String purpose;
}
