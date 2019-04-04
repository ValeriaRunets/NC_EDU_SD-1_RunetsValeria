package backend.service.impl;

import backend.entity.Meeting;
import backend.repository.MeetingRepository;
import backend.service.MeetingService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingRepository repository;
    @Override
    public Meeting getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addMeeting(Meeting meeting) {
        repository.save(meeting);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Meeting> getAll() {
        return (List<Meeting>) repository.findAll();
    }
}
