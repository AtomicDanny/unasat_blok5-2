package sr.unasat.ride.entity;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "classification_id", referencedColumnName = "id")
    private Classification classification;

    @Column
    private String model;

    @Column
    private Integer bouwjaar;

    @Column
    private Double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getBouwjaar() {
        return bouwjaar;
    }

    public void setBouwjaar(Integer bouwjaar) {
        this.bouwjaar = bouwjaar;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}