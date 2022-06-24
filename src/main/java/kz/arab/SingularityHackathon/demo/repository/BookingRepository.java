package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.RowMapper.IdMapper;
import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import kz.arab.SingularityHackathon.demo.RowMapper.BookingDtoMapper;
import kz.arab.SingularityHackathon.demo.dto.IdDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookingDto> findAllByUserIdAndDateGreaterThanEqual(Long userId){
        return jdbcTemplate.query("SELECT t.time_slot, booking.date,  r.room_number, booking.purpose FROM booking JOIN timeslots t on t.id = booking.time_slot_id JOIN rooms r on booking.room_id = r.id WHERE date >= now() and user_id = ?", new BookingDtoMapper(), new Object[]{userId});
    }

    public List<IdDto> findReservedTimeSlots(Long roomId, Date date){
        return jdbcTemplate.query("SELECT time_slot_id FROM booking WHERE room_id = ? and date = ?", new IdMapper() ,new Object[]{roomId, date});
    }

    public void saveNewBooking(Long userId, Long timeSlotId, Date date, Long roomId, String purpose){
        jdbcTemplate.update("INSERT INTO booking(user_id, time_slot_id, date, room_id, purpose) VALUES (?, ?, ?, ?, ?)", userId, timeSlotId, date, roomId, purpose);
    }
}
