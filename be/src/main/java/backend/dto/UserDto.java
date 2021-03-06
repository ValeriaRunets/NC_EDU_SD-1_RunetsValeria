package backend.dto;

import java.util.*;

public class UserDto {
    private String id;
    private String name;
    private String password;
    private String login;
    private String role;
    private Collection<String> meetingsId;
    private boolean firstEntr;

    public UserDto() {meetingsId=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<String> getMeetingsId() {
        return meetingsId;
    }

    public void setMeetingsId(Collection<String> meetingsId) {
        this.meetingsId = meetingsId;
    }

    public boolean isFirstEntr() {
        return firstEntr;
    }

    public void setFirstEntr(boolean firstEntr) {
        this.firstEntr = firstEntr;
    }
}
