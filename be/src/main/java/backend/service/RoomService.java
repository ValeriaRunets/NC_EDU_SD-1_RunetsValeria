package backend.service;

import backend.entity.Room;
import java.util.*;

public interface RoomService {

    void delete(long id);
    Room addRoom(Room room);
    Room getById(long id);
    List<Room> getAll();
    List<Room> getFree(Date date1, Date date2);
    int count();
    List<Room> getPage(int page);
}
