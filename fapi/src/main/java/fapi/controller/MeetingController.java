package fapi.controller;

import fapi.service.MeetingService;
import fapi.models.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api1/meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @RequestMapping(path="/meeting/{id}", method= RequestMethod.GET)
    public Meeting getById(@PathVariable(name="id") long id){
        return meetingService.getById(id);
    }

    @RequestMapping(path="/add", method= RequestMethod.POST)
    public void addMeeting(@RequestBody Meeting meeting){
        meetingService.addMeeting(meeting);
    }

    @RequestMapping(path="/deleteMeeting/{id}", method= RequestMethod.GET)
    public void delete(@PathVariable(name="id") long id){
        meetingService.delete(id);
    }

    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<Meeting> getAll(){
        return meetingService.getAll();
    }
}
