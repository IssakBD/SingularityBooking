package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.entity.TimeSlot;
import org.springframework.data.repository.CrudRepository;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
}
