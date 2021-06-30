package sr.unasat.ride.builder;

import sr.unasat.ride.entity.Car;
import sr.unasat.ride.entity.Decorator;
import sr.unasat.ride.entity.Klant;
import sr.unasat.ride.entity.Register;

import java.util.Date;
import java.util.List;

public class RegisterBuilder {

    public Car car;
    public Klant klant;
    public Date start_date;
    public Date end_date;
    public Double total;

    public List<Decorator> decoratorList;

    public RegisterBuilder(Car car,Klant klant, Date start_date, Date end_date, Double total){
        this.klant=klant;
        this.car =car;
        this.start_date=start_date;
        this.end_date = end_date;
        this.total=total;
    }

    public RegisterBuilder setDecoratorList(List<Decorator> decoratorList) {
        this.decoratorList = decoratorList;
        return this;
    }


    public Register build(){
        return new Register(this);
    }
}
