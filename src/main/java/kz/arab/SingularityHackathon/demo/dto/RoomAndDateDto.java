package kz.arab.SingularityHackathon.demo.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class RoomAndDateDto {
    private Long roomNumber;
    private Date date;
}
