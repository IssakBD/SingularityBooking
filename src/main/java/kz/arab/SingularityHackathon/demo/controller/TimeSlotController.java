package kz.arab.SingularityHackathon.demo.controller;

import kz.arab.SingularityHackathon.demo.entity.TimeSlot;
import kz.arab.SingularityHackathon.demo.repository.TimeSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timeslots")
@RequiredArgsConstructor
public class TimeSlotController {

    private final TimeSlotRepository timeSlotRepository;

    @GetMapping
    public List<TimeSlot> getTimeSlots(){
        System.out.println(timeSlotRepository.findAll());
        return timeSlotRepository.findAll();
    }
}
