package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.dto.BookingDtoToDB;
import kz.arab.SingularityHackathon.demo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepositoryJpa extends JpaRepository<Booking, Long> {
//    public BookingDtoToDB save(BookingDtoToDB bookingDtoToDB);
}
