package sr.unasat.ride.entity;

import sr.unasat.ride.builder.RegisterBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "klant_id", referencedColumnName = "id")
    private Klant klant;

    @Column
    private Date start_date;

    @Column
    private Date end_date;

    @Column
    private Double total;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @Column
    @JoinTable(
            name = "register_decorator",
            joinColumns = { @JoinColumn(name = "register_id") },
            inverseJoinColumns = { @JoinColumn(name = "decorator_id") }
    )

    private List<Decorator> decoratorList;

    public Register(RegisterBuilder registerBuilder){
        this.car = registerBuilder.car;
        this.klant = registerBuilder.klant;
        this.start_date =registerBuilder.start_date;
        this.end_date =registerBuilder.end_date;
        this.total= registerBuilder.total;
        this.decoratorList =registerBuilder.decoratorList;
    }

    public Register(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Decorator> getDecoratorList() {
        return decoratorList;
    }

    public void setDecoratorList(List<Decorator> decoratorList) {
        this.decoratorList = decoratorList;
    }
}
