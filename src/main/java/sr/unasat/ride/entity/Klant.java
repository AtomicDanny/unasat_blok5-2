package sr.unasat.ride.entity;


import javax.persistence.*;

@Entity
@Table(name = "klanten")
public class Klant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naam;
    @Column
    private String geslacht;
    @Column(name = "tel_nummer")
    private String telNummer;
    @Column
    private String email;

    public Klant(String naam, String geslacht, String telNummer, String email) {
        this.naam = naam;
        this.geslacht = geslacht;
        this.telNummer = telNummer;
        this.email = email;
    }

    public Klant(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getTelNummer() {
        return telNummer;
    }

    public void setTelNummer(String telNummer) {
        this.telNummer = telNummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
