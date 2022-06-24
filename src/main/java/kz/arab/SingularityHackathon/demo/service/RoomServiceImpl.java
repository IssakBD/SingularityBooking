package kz.arab.SingularityHackathon.demo.service;

import kz.arab.SingularityHackathon.demo.entity.Rooms;
import kz.arab.SingularityHackathon.demo.repository.RoomsRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomsRepository roomsRepository;

    public RoomServiceImpl(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @Override
    public Rooms findFirstByRoomNumber(Long roomNumber) {
        return roomsRepository.findFirstByRoomNumber(roomNumber);
    }

    @Override
    public Rooms findAllByRoomNumber(Long roomNumber) {
        return roomsRepository.findAllByRoomNumber(roomNumber);
    }
}
