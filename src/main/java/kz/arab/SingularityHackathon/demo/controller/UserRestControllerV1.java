package kz.arab.SingularityHackathon.demo.controller;

import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import kz.arab.SingularityHackathon.demo.dto.UserDto;
import kz.arab.SingularityHackathon.demo.entity.Booking;
import kz.arab.SingularityHackathon.demo.entity.User;
import kz.arab.SingularityHackathon.demo.service.BookingService;
import kz.arab.SingularityHackathon.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/")
public class UserRestControllerV1 {
    private final UserService userService;
    private final BookingService bookingService;

    @Autowired
    public UserRestControllerV1(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
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
    public ResponseEntity getMyBookings(@PathVariable(name = "id") Long id){
        List<BookingDto> booking = bookingService.findAllByUserIdAndDateGreaterThanEqual(id);
            Map<Object, Object> response = new HashMap<>();
            if(booking == null){
                response.put("booking", "You have not booked any rooms yet");
                return ResponseEntity.ok(response);
            }
            response.put("booking", booking);
            return ResponseEntity.ok(response);
    }

}