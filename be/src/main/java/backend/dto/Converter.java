package backend.dto;

import backend.entity.Meeting;
import backend.entity.Room;
import backend.entity.User;
import backend.repository.MeetingRepository;
import backend.repository.RoomRepository;
import backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class Converter {
    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private MeetingRepository meetingRepository;

    @Autowired
    public Converter(UserRepository userRepository, RoomRepository roomRepository, MeetingRepository meetingRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.meetingRepository = meetingRepository;
    }

    public Room toRoom(RoomDto room){
        Room ans=new Room();
        if (room.getId()!=null) {
            ans.setId(Long.parseLong(room.getId()));
        }
        ans.setAmount(room.getAmount());
        ans.setAdress(room.getAdress());
        ans.setMeetings(new TreeSet<>());
        for (String id: room.getMeetingsId()){
            ans.getMeetings().add(meetingRepository.findById(Long.getLong(id)).get());
        }
        return ans;
    }
    public RoomDto fromRoom(Room room){
        RoomDto ans=new RoomDto();
        ans.setId(Long.toString(room.getId()));
        ans.setAmount(room.getAmount());
        ans.setAdress(room.getAdress());
        for (Meeting meeting: room.getMeetings()){
            ans.getMeetingsId().add(Long.toString(meeting.getId()));
        }
        return ans;
    }
    public Meeting toMeeting(MeetingDto meeting){
        Meeting ans=new Meeting();
        ans.setTheme(meeting.getTheme());
        ans.setCreator(meeting.getCreator());
        if (meeting.getId()!=null) {
            ans.setId(Long.parseLong(meeting.getId()));
        }
        ans.setDateOfTheBeginning(meeting.getDateOfTheBeginning());
        ans.setDateOfEnd(meeting.getDateOfEnd());
        for (String id : meeting.getMembersId()) {
            ans.getMembers().add(userRepository.findById(Long.parseLong(id)).get());
        }
        ans.setRoom(roomRepository.findById(Long.parseLong(meeting.getIdRoom())).get());
        return ans;
    }
    public MeetingDto fromMeeting(Meeting meeting){
        MeetingDto ans=new MeetingDto();
        ans.setTheme(meeting.getTheme());
        ans.setCreator(meeting.getCreator());
        ans.setId(Long.toString(meeting.getId()));
        ans.setDateOfTheBeginning(meeting.getDateOfTheBeginning());
        ans.setDateOfEnd(meeting.getDateOfEnd());
        for (User user: meeting.getMembers()) {
            ans.getMembersId().add(Long.toString(user.getId()));
        }
        ans.setIdRoom(Long.toString(meeting.getRoom().getId()));
        return ans;
    }
    public UserDto fromUser(User user){
        UserDto ans =new UserDto();
        ans.setId(Long.toString(user.getId()));
        ans.setLogin(user.getLogin());
        ans.setName(user.getName());
        ans.setPassword(user.getPassword());
        ans.setRole(user.getRole().toString());
        ans.setFirstEntr(user.isFirstEntr());
        for (Meeting meeting: user.getMeetings()){
            ans.getMeetingsId().add(Long.toString(meeting.getId()));
        }
        return ans;
    }
    public User toUser(UserDto user){
        User ans=new User();
        if (user.getId()!=null){
            ans.setId(Long.parseLong(user.getId()));
        }
        ans.setLogin(user.getLogin());
        ans.setName(user.getName());
        ans.setPassword(user.getPassword());
        ans.setFirstEntr(user.isFirstEntr());
        ans.setRole(User.Role.valueOf(user.getRole()));
        return ans;
    }
}
