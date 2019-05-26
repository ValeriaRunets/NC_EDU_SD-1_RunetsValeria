package backend.dto;

import java.util.*;

public class RoomDto {
    private String id;
    private int amount;
    private String adress;
    private Collection<String> meetingsId;

    public RoomDto() {meetingsId=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Collection<String> getMeetingsId() {
        return meetingsId;
    }

    public void setMeetingsId(Collection<String> meetingsId) {
        this.meetingsId = meetingsId;
    }
}
