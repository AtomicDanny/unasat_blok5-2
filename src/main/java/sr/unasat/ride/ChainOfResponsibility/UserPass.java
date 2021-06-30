package sr.unasat.ride.ChainOfResponsibility;

import sr.unasat.ride.config.JPAConfigurations;
import sr.unasat.ride.dao.UserDAO;

public class UserPass implements User {
    private User nextInChain;

    //needs be removed if incorrect
    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private UserDAO usr = new UserDAO(jpaConfigurations.getEntityManager());

    public void next(User c) {
        nextInChain = c;
    }

    public void process(sr.unasat.ride.entity.User user) {
        if (usr.Pass(user.getUserEmail(), user.getUserPassword())) {
            System.out.println("User is validated!");
        }
        else {
            System.out.println("User is not validated!");
        }
    }
}
