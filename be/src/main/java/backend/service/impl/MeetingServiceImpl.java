package backend.service.impl;

import backend.entity.Meeting;
import backend.entity.User;
import backend.repository.MeetingRepository;
import backend.repository.UserRepository;
import backend.service.MeetingService;
import java.util.*;
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

    @Override
    public List<Meeting> getByDate(Calendar date) {
        Date d1 = new Date(date.get(Calendar.YEAR)-1900, date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH), 3, 1);
        Date d2 = new Date(date.get(Calendar.YEAR)-1900, date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH)+1, 2, 59);
        return repository.findAllByDateOfEndBetweenOrderByDateOfTheBeginning(d1, d2);
    }

    @Override
    public void deleteForCur(Meeting meeting, String login) {
        User user = repos.findByLogin(login);
        meeting.getMembers().remove(user);
        repository.save(meeting);
    }
}
