package backend.service.impl;

import backend.entity.Room;
import backend.repository.MeetingRepository;
import backend.repository.RoomRepository;
import backend.service.RoomService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    int SIZE_OF_PAGE=5;
    @Autowired
    private RoomRepository repository;
    @Autowired
    private MeetingRepository repos;
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

    @Override
    public List<Room> getFree(Date date1, Date date2) {
        GregorianCalendar cal=new GregorianCalendar();
        String str1=date1.toInstant().plusSeconds(3*3600).toString();
        String str2=date2.toInstant().plusSeconds(3*3600).toString();
        return repository.findFree(str1, str2);
    }

    @Override
    public int count() {
        return (int)repository.count();
    }

    @Override
    public List<Room> getPage(int page) {
        return  repository.findAll(PageRequest.of(page, SIZE_OF_PAGE, Sort.by("adress"))).getContent();
    }
}
