package backend.dto;

import java.util.*;
import java.util.Date;

public class MeetingDto {
    private String id;
    private String creator;
    private Date dateOfTheBeginning;
    private Date dateOfEnd;
    private String theme;
    private String idRoom;
    private int timeOfNotification;
    private Collection<String> membersId;

    MeetingDto(){membersId=new ArrayList<>(); }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDateOfTheBeginning() {
        return dateOfTheBeginning;
    }

    public void setDateOfTheBeginning(Date dateOfTheBeginning) {
        this.dateOfTheBeginning = dateOfTheBeginning;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public int getTimeOfNotification() {
        return timeOfNotification;
    }

    public void setTimeOfNotification(int timeOfNotification) {
        this.timeOfNotification = timeOfNotification;
    }

    public Collection<String> getMembersId() {
        return membersId;
    }

    public void setMembersId(Collection<String> membersId) {
        this.membersId = membersId;
    }
}
