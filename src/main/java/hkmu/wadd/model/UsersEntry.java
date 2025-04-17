//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hkmu.wadd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(
    name = "users"
)
public class UsersEntry {
    @Id
    @GeneratedValue(
        strategy = GenerationType.UUID
    )
    private UUID id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phonenumber;
    private String role;

    public UsersEntry() {
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = "{noop}" + password;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = "ROLE_USER";
    }

    public String toString() {
        String var10000 = String.valueOf(this.id);
        return "UserEntry{id='" + var10000 + "', username='" + this.username + "', password='" + this.password + "', fullname='" + this.fullname + "', email='" + this.email + "', phonenumber='" + this.phonenumber + "', role='" + this.role + "}";
    }
}
