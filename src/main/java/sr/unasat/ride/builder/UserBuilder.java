package sr.unasat.ride.builder;

import sr.unasat.ride.entity.User;

public class UserBuilder {

    //Required
    public String userFirstName;
    public String userLastName;
    public String userEmail;
    public String userPassword;

    public UserBuilder(){}

    public UserBuilder(String userFirstName, String userLastName, String userEmail, String userPassword) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }


    public User build(){
        return new User(this);
    }

}
