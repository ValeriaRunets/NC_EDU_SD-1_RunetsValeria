package backend.service;

import backend.entity.Meeting;
import java.util.*;

public interface MeetingService {

    Meeting getById(long id);
    void addMeeting(Meeting meeting);
    void delete(long id);
    void deleteForCur(Meeting meeting, String login);
    List<Meeting> getAll();
    List<Meeting> getByDate(Calendar date);
}
