package sr.unasat.ride.ChainOfResponsibility;

public interface User {
    void next(User nextInChain);
    void process(sr.unasat.ride.entity.User user);
}
