 package fapi.controller;

        import fapi.security.SecurityJwtConstants;
        import fapi.security.TokenProvider;
        import fapi.service.MeetingService;
        import fapi.models.Meeting;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.*;

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
        String str=tokenProvider.getUsernameFromToken(token.replace(SecurityJwtConstants.TOKEN_PREFIX+" ", ""));
        meeting.setCreator(str);
        meetingService.addMeeting(meeting);
    }
    @RequestMapping(method= RequestMethod.POST, path="/date", produces = "application/json")
    public List<Meeting> getByDate(@RequestBody Calendar date, @RequestHeader("Authorization") String token){
        String str=tokenProvider.getUsernameFromToken(token.replace(SecurityJwtConstants.TOKEN_PREFIX+" ", ""));
        return meetingService.getByDate(date, str);
    }

    @RequestMapping(path="/{id}/{creator}", method= RequestMethod.DELETE)
    public void delete(@PathVariable(name="id") long id, @PathVariable(name="creator") String creator, @RequestHeader("Authorization") String token){
        String str=tokenProvider.getUsernameFromToken(token.replace(SecurityJwtConstants.TOKEN_PREFIX+" ", ""));
        if (str.equals(creator)) {
            meetingService.delete(id);
        } else{
            meetingService.deleteForCur(meetingService.getById(id) ,str);
        }
    }
    @RequestMapping(path="/{login}", method= RequestMethod.PUT)
    public void deleteForCur(@PathVariable(name="login") String login, @RequestBody Meeting meeting){
        meetingService.deleteForCur(meeting, login);
    }

    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<Meeting> getAll(){
        return meetingService.getAll();
    }
}