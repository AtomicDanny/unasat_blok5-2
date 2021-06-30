package sr.unasat.ride.ChainOfResponsibility;

import sr.unasat.ride.config.JPAConfigurations;
import sr.unasat.ride.dao.UserDAO;


public class UserCheck implements User {
    private User next;

    JPAConfigurations jpaConfigurations = new JPAConfigurations();

    private UserDAO usr = new UserDAO(jpaConfigurations.getEntityManager());

    public void next(User user) {
        next = user;
    }

    public void process(sr.unasat.ride.entity.User user) {
        if (!usr.Check(user.getUserEmail())) {
            System.out.println("Unauthorized!");
        }
        else {
            next.process(user);
        }
    }
}
