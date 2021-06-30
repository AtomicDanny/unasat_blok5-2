package sr.unasat.ride.builder;

import sr.unasat.ride.entity.Decorator;

public class DecoratorBuilder {

    //Required
    public Long id;
    public String name;

    public DecoratorBuilder(){}

    public DecoratorBuilder(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Decorator build(){
        return new Decorator(this);
    }
}
