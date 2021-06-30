package sr.unasat.ride.entity;

import sr.unasat.ride.builder.UserBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long userId;

    @Column
    private String userFirstName;

    @Column
    private String userLastName;

    @Column(unique = true, nullable = false)
    private String userEmail;

    @Column
    private String userPassword;


    @ManyToMany
    @JoinTable(
            name = "GarageUser",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "garageId"))
    List<Warehouse> userWarehouse;

    public User(){}

    public User(String userFirstName, String userLastName, String userEmail, String userPassword) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(UserBuilder userBuilder){
        this.userFirstName = userBuilder.userFirstName;
        this.userLastName = userBuilder.userLastName;
        this.userEmail = userBuilder.userEmail;
        this.userPassword = userBuilder.userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public List<Warehouse> getUserWarehouse() {
        return userWarehouse;
    }

    public void setUserWarehouse(List<Warehouse> userWarehouse) {
        this.userWarehouse = userWarehouse;
    }

}
