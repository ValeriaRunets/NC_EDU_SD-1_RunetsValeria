package backend.service;

import backend.entity.Room;
import java.util.*;

public interface RoomService {

    void delete(long id);
    Room addRoom(Room room);
    Room getById(long id);
    List<Room> getAll();
}