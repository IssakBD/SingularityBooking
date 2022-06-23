package kz.arab.SingularityHackathon.demo.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDtoMapper implements RowMapper<BookingDto> {
    @Override
    public BookingDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookingDto BookingDto = new BookingDto();

        BookingDto.setId(rs.getLong("id"));
        BookingDto.setTimeSlot(rs.getString("time_slot"));
        BookingDto.setDate(rs.getDate("date"));
        BookingDto.setRoom(rs.getLong("room_number"));

        return BookingDto;
    }
}
