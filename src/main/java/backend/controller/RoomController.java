package backend.controller;

import backend.entity.Room;
import backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    @RequestMapping(path="/deleteRoom", method= RequestMethod.GET)
    public void delete(@RequestParam long id){
        roomService.delete(id);
    }

    @RequestMapping(path="/addRoom", method= RequestMethod.POST)
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @RequestMapping(path="/room", method= RequestMethod.GET)
    public Room getById(@RequestParam long id){
        return roomService.getById(id);
    }

    @RequestMapping(path="/allRooms", method= RequestMethod.GET)
    public List<Room> getAll(){
        return roomService.getAll();
    }
}
