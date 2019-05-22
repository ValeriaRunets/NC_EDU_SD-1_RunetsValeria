package fapi.service;

import fapi.models.Meeting;

import java.util.*;

public interface MeetingService {

    Meeting getById(long id);
    Meeting addMeeting(Meeting meeting);
    void delete(long id);
    void deleteForCur(Meeting meeting, String login);
    List<Meeting> getAll();
    List<Meeting> getByDate(Calendar date, String login);
}
