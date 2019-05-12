package fapi.service.impl;

import java.util.*;

import fapi.models.Meeting;
import fapi.service.MeetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Meeting getById(long id) {
        return new Meeting();
    }

    @Override
    public Meeting addMeeting(Meeting meeting) {
        RestTemplate restTemplate= new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl+"api/meeting/", meeting, Meeting.class).getBody();
    }

    @Override
    public void delete(long id) {
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.delete(backendServerUrl+"api/meeting/"+id);
    }

    @Override
    public List<Meeting> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Meeting[] meetingResponse = restTemplate.getForObject(backendServerUrl + "api/meeting/all", Meeting[].class);
        return meetingResponse == null ? Collections.emptyList() : Arrays.asList(meetingResponse);
    }
}
