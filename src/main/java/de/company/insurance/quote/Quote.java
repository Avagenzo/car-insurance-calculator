package de.company.insurance.quote;

import jakarta.persistence.*;

@Entity
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int jahresKilometer;
    private String fahrzeugtyp;
    private String postleitzahl;
    private double praemie;

    public Quote() {}

    public Quote(int jahresKilometer, String fahrzeugtyp, String postleitzahl, double praemie) {
        this.jahresKilometer = jahresKilometer;
        this.fahrzeugtyp = fahrzeugtyp;
        this.postleitzahl = postleitzahl;
        this.praemie = praemie;
    }

    // Getter/Setter (alle Felder)
    public Long getId() { return id; }
    public int getJahresKilometer() { return jahresKilometer; }
    public void setJahresKilometer(int v) { this.jahresKilometer = v; }
    public String getFahrzeugtyp() { return fahrzeugtyp; }
    public void setFahrzeugtyp(String v) { this.fahrzeugtyp = v; }
    public String getPostleitzahl() { return postleitzahl; }
    public void setPostleitzahl(String v) { this.postleitzahl = v; }
    public double getPraemie() { return praemie; }
    public void setPraemie(double v) { this.praemie = v; }
}
