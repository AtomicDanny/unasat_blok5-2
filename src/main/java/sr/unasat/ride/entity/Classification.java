package sr.unasat.ride.entity;


import javax.persistence.*;

@Entity
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "class")
    private String classification;


    public Classification(String classification) {
        this.classification = classification;

    }

    public Classification() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}