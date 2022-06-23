package kz.arab.SingularityHackathon.demo.service;

import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import kz.arab.SingularityHackathon.demo.entity.Booking;

import java.sql.Date;
import java.util.List;

public interface BookingService {
    public List<BookingDto> findAllByUserIdAndDateGreaterThanEqual(Long userId);

}
