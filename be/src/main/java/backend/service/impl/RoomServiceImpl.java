package backend.service.impl;

import backend.entity.Room;
import backend.repository.RoomRepository;
import backend.service.RoomService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repository;
    @Override
    public void delete(long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public Room addRoom(Room room) {
        return repository.save(room);
    }

    @Override
    public Room getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Room> getAll() {
        return (List<Room>)repository.findAll();
    }
}
