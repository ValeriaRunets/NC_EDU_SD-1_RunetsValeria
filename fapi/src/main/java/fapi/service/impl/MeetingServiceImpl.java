package fapi.service.impl;

import java.util.*;

import fapi.models.Meeting;
import fapi.service.MeetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Meeting getById(long id) {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"api/meeting/" + id, Meeting.class);
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

    @Override
    public List<Meeting> getByDate(Calendar date, String login) {
        RestTemplate restTemplate = new RestTemplate();
        Meeting[] meetingResponse = restTemplate.postForObject(backendServerUrl + "api/meeting/date/"+login, date, Meeting[].class);
        return meetingResponse == null ? Collections.emptyList() : Arrays.asList(meetingResponse);
    }

    @Override
    public void deleteForCur(Meeting meeting, String login) {
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.put(backendServerUrl+"api/meeting/"+login, meeting, Meeting.class);
    }
}
