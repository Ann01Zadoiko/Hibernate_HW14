package org.example.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "planets")

public class Planet {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 500)
    private String name;


    @OneToMany (mappedBy = "fromPlanetId", fetch = FetchType.LAZY)
    private List<Ticket> fromTickets;

    @OneToMany (mappedBy = "toPlanetId", fetch = FetchType.LAZY)
    private List<Ticket> toPlanet;

    public List<Ticket> getFromTickets() {
        return fromTickets;
    }

    public void setFromTickets(List<Ticket> fromTickets) {
        this.fromTickets = fromTickets;
    }

    public List<Ticket> getToPlanet() {
        return toPlanet;
    }

    public void setToPlanet(List<Ticket> toPlanet) {
        this.toPlanet = toPlanet;
    }

    public Planet(){}

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
