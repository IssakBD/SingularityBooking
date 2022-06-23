package kz.arab.SingularityHackathon.demo.service;

import kz.arab.SingularityHackathon.demo.entity.TimeSlot;
import kz.arab.SingularityHackathon.demo.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    @Override
    public TimeSlot findAllById(Long id) {
        return timeSlotRepository.findAllById(id);
    }

    @Override
    public List<TimeSlot> findTimeSlotByIdIsNot(Long id) {
        return timeSlotRepository.findTimeSlotByIdIsNot(id);
    }
}
