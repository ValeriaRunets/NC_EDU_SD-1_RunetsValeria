package fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

import java.util.Date;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meeting {
    private long id;
    private Date dateOfTheBeginning;
    private Date dateOfEnd;
    private String theme;
    private Room room;
    private int timeOfNotification;
    private Collection<User> members;

    public Meeting(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getTimeOfNotification() {
        return timeOfNotification;
    }

    public void setTimeOfNotification(int timeOfNotification) {
        this.timeOfNotification = timeOfNotification;
    }

    public Collection<User> getMembers() {
        return members;
    }

    public void setMembers(Collection<User> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meeting)) return false;
        Meeting meeting = (Meeting) o;
        return getId() == meeting.getId() &&
                getTimeOfNotification() == meeting.getTimeOfNotification() &&
                Objects.equals(getDateOfTheBeginning(), meeting.getDateOfTheBeginning()) &&
                Objects.equals(getDateOfEnd(), meeting.getDateOfEnd()) &&
                Objects.equals(getTheme(), meeting.getTheme()) &&
                Objects.equals(getRoom(), meeting.getRoom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateOfTheBeginning(), getDateOfEnd(),  getTheme(), getRoom(), getTimeOfNotification());
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", dateOfTheBeginning=" + dateOfTheBeginning +
                ", dateOfEnd=" + dateOfEnd +
                ", theme='" + theme + '\'' +
                ", room=" + room +
                ", timeOfNotification=" + timeOfNotification +
                ", members=" +
                '}';
    }
}

