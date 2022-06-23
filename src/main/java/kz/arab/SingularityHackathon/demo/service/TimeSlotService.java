package kz.arab.SingularityHackathon.demo.service;

import kz.arab.SingularityHackathon.demo.entity.TimeSlot;

import java.util.List;

public interface TimeSlotService {
    public TimeSlot findAllById(Long id);

    public List<TimeSlot> findTimeSlotByIdIsNot(Long id);
}
