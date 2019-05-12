package backend.controller;

import backend.entity.Meeting;
import backend.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @RequestMapping(path="/meeting/{id}", method= RequestMethod.GET)
    public Meeting getById(@PathVariable(name="id") long id){
        return meetingService.getById(id);
    }

    @RequestMapping(method= RequestMethod.POST)
    public void addMeeting(@RequestBody Meeting meeting){
        meetingService.addMeeting(meeting);
    }

    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable(name="id") long id){
        meetingService.delete(id);
    }

    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<Meeting> getAll(){
        return meetingService.getAll();
    }
}
