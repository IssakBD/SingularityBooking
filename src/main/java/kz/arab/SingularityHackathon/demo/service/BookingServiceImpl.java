package kz.arab.SingularityHackathon.demo.service;

import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import kz.arab.SingularityHackathon.demo.dto.BookingDtoToDB;
import kz.arab.SingularityHackathon.demo.dto.IdDto;
import kz.arab.SingularityHackathon.demo.entity.Booking;
import kz.arab.SingularityHackathon.demo.repository.BookingRepository;
import kz.arab.SingularityHackathon.demo.repository.BookingRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final BookingRepositoryJpa bookingRepositoryJpa;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingRepositoryJpa bookingRepositoryJpa) {
        this.bookingRepository = bookingRepository;
        this.bookingRepositoryJpa = bookingRepositoryJpa;
    }

    @Override
    public List<BookingDto> findAllByUserIdAndDateGreaterThanEqual(Long userId) {
        return bookingRepository.findAllByUserIdAndDateGreaterThanEqual(userId);
    }

    @Override
    public List<IdDto> findReservedTimeSlots(Long roomId, Date date) {
        return bookingRepository.findReservedTimeSlots(roomId, date);
    }

    @Override
    public void saveNewBooking(BookingDtoToDB bookingDtoToDB) {
        bookingRepository.saveNewBooking(bookingDtoToDB.getUserId(), bookingDtoToDB.getTimeSlotId(), bookingDtoToDB.getDate(), bookingDtoToDB.getRoomId(), bookingDtoToDB.getPurpose());
    }
}
