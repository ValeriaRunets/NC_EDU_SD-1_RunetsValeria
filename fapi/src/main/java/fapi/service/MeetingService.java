package fapi.service;

import fapi.models.Meeting;

import java.util.*;

public interface MeetingService {

    Meeting getById(long id);
    Meeting addMeeting(Meeting meeting);
    void delete(long id);
    List<Meeting> getAll();
}
