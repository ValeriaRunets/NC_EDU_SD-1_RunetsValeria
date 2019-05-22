package backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

import java.util.Date;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name= "meeting")
public class Meeting {
    private long id;
    private String creator;
    private Date dateOfTheBeginning;
    private Date dateOfEnd;
    private String theme;
    private Room room;
    private int timeOfNotification;
    private Collection<User> members;

    public Meeting(){ members = new ArrayList<>();}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Column(name="DateOfTheBeginning")
    public Date getDateOfTheBeginning() {
        return dateOfTheBeginning;
    }

    public void setDateOfTheBeginning(Date dateOfTheBeginning) {
        this.dateOfTheBeginning = dateOfTheBeginning;
    }

    @Column(name="DateOfEnd")
    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }


    @Column(name="theme")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @ManyToOne()
    @JoinColumn(name="room_id")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Column(name="timeOfNotification")
    public int getTimeOfNotification() {
        return timeOfNotification;
    }

    public void setTimeOfNotification(int timeOfNotification) {
        this.timeOfNotification = timeOfNotification;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_has_meeting",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public Collection<User> getMembers() {
        return members;
    }

    public void setMembers(Collection<User> members) {
        this.members = members;
    }
}
