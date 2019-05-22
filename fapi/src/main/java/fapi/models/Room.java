package fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {
    private String id;
    private int amount;
    private String adress;
    private Collection<String> meetingsId;

    public Room(){meetingsId=new ArrayList<>();}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Collection<String> getMeetingsId() {
        return meetingsId;
    }

    public void setMeetingsId(Collection<String> meetingsId) {
        this.meetingsId = meetingsId;
    }
}
