package backend.entity;

import java.util.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="room")
public class Room {
    private long id;
    private int amount;
    private String adress;
    private Collection<Meeting> meetings;

    public Room(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Column(name="amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @OneToMany(mappedBy = "room")
    public Collection<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Collection<Meeting> meetings) {
        this.meetings = meetings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getId() == room.getId() &&
                getAmount() == room.getAmount() &&
                Objects.equals(getAdress(), room.getAdress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getAdress());
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", amount=" + amount +
                ", adress='" + adress + '\'' +
                ", meetings=" + meetings +
                '}';
    }
}
