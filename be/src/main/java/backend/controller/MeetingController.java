package backend.controller;

import backend.dto.Converter;
import backend.dto.MeetingDto;
import backend.entity.Meeting;
import backend.entity.User;
import backend.service.MeetingService;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.util.List;

@RestController
@RequestMapping("api/meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @Autowired
    private UserService userService;
    @Autowired
    private Converter converter;

    @RequestMapping(path="/meeting/{id}", method= RequestMethod.GET)
    public MeetingDto getById(@PathVariable(name="id") long id){
        return converter.fromMeeting(meetingService.getById(id));
    }

    @RequestMapping(method= RequestMethod.POST)
    public void addMeeting(@RequestBody MeetingDto meeting){
        meetingService.addMeeting(converter.toMeeting(meeting));
    }

    @RequestMapping(method= RequestMethod.POST, path="/date/{login}")
    public List<MeetingDto> getByDate(@RequestBody Calendar date, @PathVariable(name="login") String login){
        List<MeetingDto> list=new ArrayList<>();
        date.get(Calendar.DAY_OF_WEEK);
        User user =userService.findByLogin(login);
        for (Meeting meeting:meetingService.getByDate(date)) {
            if (meeting.getMembers().contains(user) || meeting.getCreator().equals(login)) {
                list.add(converter.fromMeeting(meeting));
            }
        }
        return list;
    }

    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable(name="id") long id){
        meetingService.delete(id);
    }

    @RequestMapping(path="/{login}", method= RequestMethod.PUT)
    public void deleteForCur(@PathVariable(name="login") String login, @RequestBody MeetingDto meeting){
        Meeting meet=converter.toMeeting(meeting);
        meetingService.deleteForCur(meet, login);
    }

    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<MeetingDto> getAll(){
        List<MeetingDto> list=new ArrayList<>();
        for (Meeting meeting:meetingService.getAll()){
            list.add(converter.fromMeeting(meeting));
        }
        return list;
    }
}
