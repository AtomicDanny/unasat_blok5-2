package sr.unasat.ride.entity;

import sr.unasat.ride.builder.DecoratorBuilder;
import sr.unasat.ride.builder.UserBuilder;

import javax.persistence.*;

@Entity
@Table(name = "decorator")
public class Decorator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

//    public Decorator(String name, Double price) {
////        this.name = name;
////        this.price = price;
////    }
    public Decorator(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    public Decorator(DecoratorBuilder decoratorBuilder){
//        this.name = decoratorBuilder.name;
//    }
}
