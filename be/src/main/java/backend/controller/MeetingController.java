package backend.controller;

import backend.entity.Meeting;
import backend.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @RequestMapping(path="/meeting/{id}", method= RequestMethod.GET)
    public Meeting getById(@PathVariable(name="id") long id){
        return meetingService.getById(id);
    }

    @RequestMapping(path="/addMeeting", method= RequestMethod.POST)
    public void addMeeting(@RequestBody Meeting meeting){
        meetingService.addMeeting(meeting);
    }

    @RequestMapping(path="/deleteMeeting/{id}", method= RequestMethod.GET)
    public void delete(@PathVariable(name="id") long id){
        meetingService.delete(id);
    }

    @RequestMapping(path="/getAllMeetings", method= RequestMethod.GET)
    public List<Meeting> getAll(){
        return meetingService.getAll();
    }
}
