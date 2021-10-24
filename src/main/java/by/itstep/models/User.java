package by.itstep.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @OneToOne
    @JoinColumn(name = "role_id")
    private  Role  role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private LogRecord logRecord;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "\n" +
                " id = " + id +
                ", userName = " + userName +
                ", role = " + role ;
    }
}
