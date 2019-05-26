package fapi.controller;

import fapi.service.RoomService;
import fapi.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api1/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id){
        roomService.delete(id);
    }

    @RequestMapping(method= RequestMethod.POST, produces = "application/json")
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET)
    public Room getById(@PathVariable(name="id") long id){
        return roomService.getById(id);
    }

    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<Room> getAll(){
        return roomService.getAll();
    }

    @RequestMapping(path="/free", method= RequestMethod.POST, produces = "application/json")
    public List<Room> getFree(@RequestBody Date[] dates){
        return roomService.getFree(dates[0], dates[1]);
    }
}
