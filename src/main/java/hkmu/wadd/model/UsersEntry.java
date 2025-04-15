package hkmu.wadd.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UsersEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phonenumber;
    private String role;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = "{noop}" + password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = "ROLE_USER";
    }

    @Override
    public String toString() {
        return "UserEntry{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", role='" + role +
                '}';
    }
}