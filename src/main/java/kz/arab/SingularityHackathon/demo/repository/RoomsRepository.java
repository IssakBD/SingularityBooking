package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    public Rooms findFirstByRoomNumber(Long roomNumber);
}
