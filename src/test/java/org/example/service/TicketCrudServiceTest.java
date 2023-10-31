package org.example.service;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TicketCrudServiceTest {

    @Test
    void save() {
        TicketCrudService ticketCrudService = new TicketCrudService();

        Ticket ticket = new Ticket();

        Client client = new Client();
        client.setName("Something");

        Planet fromPlanet = new Planet();
        fromPlanet.setId("FSTH");
        fromPlanet.setName("from something");

        Planet toPlanet = new Planet();
        toPlanet.setId("TSTH");
        toPlanet.setName("to something");

        ticket.setClientId(client);
        ticket.setFromPlanetId(fromPlanet);
        ticket.setToPlanetId(toPlanet);

        ticketCrudService.save(ticket);
    }

    @Test
    void findById() {
        TicketCrudService ticketCrudService = new TicketCrudService();
        Ticket ticket = ticketCrudService.findById(1L);
        assertEquals("Neptune",ticket.getToPlanetId().getName());
    }

    @Test
    void update() {
        TicketCrudService ticketCrudService = new TicketCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        Planet planet = planetCrudService.findById("NEP");
        Ticket ticket = ticketCrudService.findById(1L);
        ticket.setToPlanetId(planet);
        ticketCrudService.update(ticket);
    }

    @Test
    void delete() {
        TicketCrudService ticketCrudService = new TicketCrudService();
        Ticket ticket = ticketCrudService.findById(1L);
        ticketCrudService.delete(ticket);
    }
}