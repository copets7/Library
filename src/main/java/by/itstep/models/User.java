package by.itstep.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "user")
@ApiModel(value = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Идентификатор первичного ключа")
    private int id;
    @Column(name = "user_name")
    @ApiModelProperty(value = "Имя пользователя")
    private String userName;
    @Column(name = "email")
    @ApiModelProperty(value = "Почтовый ящик")
    private String email;
    @Column(name = "password")
    @ApiModelProperty(value = "Пароль")
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    @ApiModelProperty(value = "Роль пользователя")
    private Role role;


    public User() {
    }

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }


}
