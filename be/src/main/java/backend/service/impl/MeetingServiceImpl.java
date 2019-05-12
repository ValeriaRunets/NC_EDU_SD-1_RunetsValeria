package backend.service.impl;

import backend.entity.Meeting;
import backend.repository.MeetingRepository;
import backend.repository.UserRepository;
import backend.service.MeetingService;
import java.util.*;

import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingRepository repository;
    @Autowired
    private UserRepository repos;
    @Override
    public Meeting getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addMeeting(Meeting meeting) {
        meeting.getMembers().add(repos.findByLogin(meeting.getCreator()));
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
