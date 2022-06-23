package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import kz.arab.SingularityHackathon.demo.dto.BookingDtoMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookingDto> findAllByUserIdAndDateGreaterThanEqual(Long userId){
        return jdbcTemplate.query("SELECT booking.id, t.time_slot, booking.date,  r.room_number FROM booking JOIN timeslots t on t.id = booking.time_slot_id JOIN rooms r on booking.room_id = r.id WHERE date >= now() and user_id = ?", new BookingDtoMapper(), new Object[]{userId});
    }
}
