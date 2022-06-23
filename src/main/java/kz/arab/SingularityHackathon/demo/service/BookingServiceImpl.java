package kz.arab.SingularityHackathon.demo.service;

import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import kz.arab.SingularityHackathon.demo.dto.IdDto;
import kz.arab.SingularityHackathon.demo.entity.Booking;
import kz.arab.SingularityHackathon.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<BookingDto> findAllByUserIdAndDateGreaterThanEqual(Long userId) {
        return bookingRepository.findAllByUserIdAndDateGreaterThanEqual(userId);
    }

    @Override
    public List<IdDto> findReservedTimeSlots(Long roomId, Date date) {
        return bookingRepository.findReservedTimeSlots(roomId, date);
    }
}
