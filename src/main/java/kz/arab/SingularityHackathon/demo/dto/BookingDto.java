package kz.arab.SingularityHackathon.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookingDto {

    private String timeSlot;
    private Date date;
    private Long room;
}
