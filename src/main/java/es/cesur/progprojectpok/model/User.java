package es.cesur.progprojectpok.model;


import javax.persistence.*;

@Entity
@Table(name = "ENTRENADOR")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column (name = "NOM_ENTRENADOR")
    private String username;
    @Column (name = "PASS")
    private String password;

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public User(){}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        this.password = password;
    }

}
