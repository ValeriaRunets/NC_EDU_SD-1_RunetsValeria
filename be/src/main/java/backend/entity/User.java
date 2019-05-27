package backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.tomcat.util.digester.ArrayStack;

import javax.persistence.*;
import java.util.Objects;
import java.util.*;

@Entity
@Table(name="user")
public class User {
    public enum Role{ADMIN, USER}
    private long id;
    private String name;
    private Role role;
    private String password;
    private String login;
    private Collection<Meeting> meetings;
    private boolean firstEntr;

    public User(){meetings=new ArrayList<>();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @ManyToMany(mappedBy = "members")
    @JsonIgnore(value = true)
    public Collection<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Collection<Meeting> meetings) {
        this.meetings = meetings;
    }

    @Column(name = "entrance")
    public boolean isFirstEntr() {
        return firstEntr;
    }

    public void setFirstEntr(boolean firstEntr) {
        this.firstEntr = firstEntr;
    }
}
