package backend.controller;

import backend.dto.Converter;
import backend.dto.RoomDto;
import backend.entity.Room;
import backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private Converter converter;
    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id){
        roomService.delete(id);
    }

    @RequestMapping(method= RequestMethod.POST)
    public Room addRoom(@RequestBody RoomDto room){
        return roomService.addRoom(converter.toRoom(room));
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET)
    public RoomDto getById(@PathVariable(name="id") long id){
        return converter.fromRoom(roomService.getById(id));
    }

    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<RoomDto> getAll(){
        List list= new ArrayList<>();
        for (Room room: roomService.getAll()){
            list.add(converter.fromRoom(room));
        }
        return list;
    }
    @RequestMapping(path="/free", method= RequestMethod.POST)
    public List<RoomDto> getFree(@RequestBody Date[] dates){
        List list= new ArrayList<>();
        for (Room room: roomService.getFree(dates[0], dates[1])){
            list.add(converter.fromRoom(room));
        }
        return list;
    }
}
