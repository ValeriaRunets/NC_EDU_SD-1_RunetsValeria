package backend.service;

import backend.entity.Meeting;
import java.util.*;

public interface MeetingService {

    Meeting getById(long id);
    void addMeeting(Meeting meeting);
    void delete(long id);
    List<Meeting> getAll();
}
