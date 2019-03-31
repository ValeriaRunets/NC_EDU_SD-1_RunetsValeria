package backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Table(name="user")
public class User {
    private enum Role{ADMIN, USER}
    private long id;
    private String name;
    private Role role;
    private String password;
    private String login;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName()) &&
                getRole() == user.getRole() &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getLogin(), user.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRole(), getPassword(), getLogin());
    }
}
