package kz.arab.SingularityHackathon.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookingDto {

    private Long id;
    private String timeSlot;
    private Date date;
    private Long room;
}
