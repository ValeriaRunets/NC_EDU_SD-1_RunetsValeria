package backend.service;

import backend.entity.Room;
import com.sun.tools.javac.util.List;

public interface RoomService {

    void delete(long id);
    Room addRoom(Room room);
    Room getById(long id);
    List<Room> getAll();
}
