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
        return new Room();
    }

    @Override
    public List<Room> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Room[] roomResponse = restTemplate.getForObject(backendServerUrl + "api/room/all", Room[].class);
        return roomResponse == null ? Collections.emptyList() : Arrays.asList(roomResponse);
    }
}