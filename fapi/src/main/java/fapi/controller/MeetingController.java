package fapi.controller;

import fapi.models.User;
import fapi.security.TokenProvider;
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

    @Autowired
    private TokenProvider tokenProvider;

    @RequestMapping(path="/meeting/{id}", method= RequestMethod.GET)
    public Meeting getById(@PathVariable(name="id") long id){
        return meetingService.getById(id);
    }

    @RequestMapping(method= RequestMethod.POST, produces = "application/json")
    public void addMeeting(@RequestBody Meeting meeting, @RequestHeader("Authorization") String token){
        String str=tokenProvider.getUsernameFromToken(token);
        meeting.setCreator(str);
        meetingService.addMeeting(meeting);
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET)
    public void delete(@PathVariable(name="id") long id){
        meetingService.delete(id);
    }

    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<Meeting> getAll(){
        return meetingService.getAll();
    }
}
