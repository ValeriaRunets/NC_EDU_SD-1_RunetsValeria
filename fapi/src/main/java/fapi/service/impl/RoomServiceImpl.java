package fapi.service.impl;

import java.util.*;

import fapi.models.Room;
import fapi.service.RoomService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoomServiceImpl implements RoomService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public void delete(long id){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.delete(backendServerUrl+"api/room/" + id);
    }

    @Override
    public Room addRoom(Room room) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "api/room/", room, Room.class).getBody();
    }

    @Override
    public Room getById(long id) {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"api/room/" + id, Room.class);
    }

    @Override
    public List<Room> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Room[] roomResponse = restTemplate.getForObject(backendServerUrl + "api/room/all", Room[].class);
        return roomResponse == null ? Collections.emptyList() : Arrays.asList(roomResponse);
    }
    public List<Room> getFree(Date date1, Date date2) {
        RestTemplate restTemplate = new RestTemplate();
        Date dates[]=new Date[2];
        dates[0]=date1;
        dates[1]=date2;
        Room[] roomResponse = restTemplate.postForObject(backendServerUrl + "api/room/free/", dates, Room[].class);
        return roomResponse == null ? Collections.emptyList() : Arrays.asList(roomResponse);
    }

    @Override
    public int count() {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"api/room/count", int.class);
    }

    @Override
    public List<Room> getPage(int page) {
        RestTemplate restTemplate = new RestTemplate();
        Room[] usersResponse = restTemplate.getForObject(backendServerUrl + "api/room/p?page="+page, Room[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }
}
