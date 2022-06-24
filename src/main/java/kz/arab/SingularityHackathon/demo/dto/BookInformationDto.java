package kz.arab.SingularityHackathon.demo.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BookInformationDto {
    private Long userId;
    private String timeSlot;
    private Date date;
    private Long roomNumber;
    private String purpose;
}
