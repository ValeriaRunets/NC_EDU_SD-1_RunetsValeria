package backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="room")
public class Room {
    private long id;
    private int amount;
    private String adress;

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
}
