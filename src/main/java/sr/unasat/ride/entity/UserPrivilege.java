package sr.unasat.ride.entity;

import javax.persistence.*;

@Entity
public class UserPrivilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long userPrivilegeId;

    @Column
    private String userRole;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    public UserPrivilege(){}

    public UserPrivilege(String userRole, User user) {
        this.userRole = userRole;
        this.user = user;
    }

    public Long getUserPrivilegeId() {
        return userPrivilegeId;
    }

    public void setUserPrivilegeId(Long userPrivilegeId) {
        this.userPrivilegeId = userPrivilegeId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
