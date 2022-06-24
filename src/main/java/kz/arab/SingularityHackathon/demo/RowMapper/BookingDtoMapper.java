package kz.arab.SingularityHackathon.demo.RowMapper;

import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDtoMapper implements RowMapper<BookingDto> {
    @Override
    public BookingDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookingDto bookingDto = new BookingDto();

        bookingDto.setTimeSlot(rs.getString("time_slot"));
        bookingDto.setDate(rs.getDate("date"));
        bookingDto.setRoom(rs.getLong("room_number"));
        bookingDto.setPurpose(rs.getString("purpose"));

        return bookingDto;
    }
}
