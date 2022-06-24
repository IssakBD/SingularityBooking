package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    public TimeSlot findAllById(Long id);

    public List<TimeSlot> findTimeSlotByIdIsNot(Long id);

    public TimeSlot findTimeSlotByTimeSlot(String timeSlot);
}