package kz.arab.SingularityHackathon.demo.controller;

import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import kz.arab.SingularityHackathon.demo.dto.IdDto;
import kz.arab.SingularityHackathon.demo.dto.UserDto;
import kz.arab.SingularityHackathon.demo.entity.Booking;
import kz.arab.SingularityHackathon.demo.entity.TimeSlot;
import kz.arab.SingularityHackathon.demo.entity.User;
import kz.arab.SingularityHackathon.demo.repository.TimeSlotRepository;
import kz.arab.SingularityHackathon.demo.service.BookingService;
import kz.arab.SingularityHackathon.demo.service.RoomService;
import kz.arab.SingularityHackathon.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping("/api/v1/user/")
public class UserRestControllerV1 {
    private final UserService userService;
    private final BookingService bookingService;

    private final RoomService roomService;

    private final TimeSlotRepository timeSlotRepository;

    @Autowired
    public UserRestControllerV1(UserService userService, BookingService bookingService, RoomService roomService, TimeSlotRepository timeSlotRepository) {
        this.userService = userService;
        this.bookingService = bookingService;
        this.roomService = roomService;
        this.timeSlotRepository = timeSlotRepository;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}/my-bookings")
    public List<BookingDto> getMyBookings(@PathVariable(name = "id") Long id){
        List<BookingDto> booking = bookingService.findAllByUserIdAndDateGreaterThanEqual(id);
            if(booking == null){
                return null;
            }
            return booking;
    }

    @GetMapping("available-time/{room}/{date}")
    public ResponseEntity getAvailableTime(@PathVariable(name = "room") Long room, @PathVariable(name = "date") Date date){
        Long roomId = roomService.findFirstByRoomNumber(room).getId();
        System.out.println(date);
        List<IdDto> reservedTimeSlotsIds = bookingService.findReservedTimeSlots(roomId, date);
        List<Long> timeSlotsId = new ArrayList<>();
        List<TimeSlot> availableTimeSlots = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        for(Long i = 1L; i <= 12; i++){
            timeSlotsId.add(i);
        }

        for (IdDto reservedTimeSlotsId : reservedTimeSlotsIds) {
            for (int i = 0; i < timeSlotsId.size(); i++) {
                if(timeSlotsId.contains(reservedTimeSlotsId.getId())){
                    timeSlotsId.remove(i);
                }
            }
        }

        for (Long aLong : timeSlotsId) {
            availableTimeSlots.add(timeSlotRepository.findAllById(aLong));
        }

        for (TimeSlot availableTimeSlot : availableTimeSlots) {
            answer.add(availableTimeSlot.getTimeSlot());
        }


//        Set<TimeSlot> availableTimeSlots = new HashSet<TimeSlot>();
//        for (IdDto reservedTimeSlotsId : reservedTimeSlotsIds) {
//           timeSlotRepository.findTimeSlotByIdIsNot(reservedTimeSlotsId.getId()).forEach(s -> availableTimeSlots.add(s));
//        }
        Map<Object, Object> response = new HashMap<>();
        if(answer.size() == 0){
            response.put("message", "There is no available time for this room to book.");
            return ResponseEntity.ok(response);
        }
        response.put("availableTimeSlots", answer);
        return ResponseEntity.ok(response);
    }
}