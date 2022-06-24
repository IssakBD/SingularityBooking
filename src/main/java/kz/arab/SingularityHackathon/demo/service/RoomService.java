package kz.arab.SingularityHackathon.demo.service;

import kz.arab.SingularityHackathon.demo.entity.Rooms;

public interface RoomService {

    public Rooms findFirstByRoomNumber(Long roomNumber);

    public Rooms findAllByRoomNumber(Long roomNumber);
}
