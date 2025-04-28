package test;

import modele.Horaire;

import static org.junit.jupiter.api.Assertions.*;

public class HoraireTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("setup");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("teardown");
    }

    Horaire h1 = new Horaire(9,15);
    Horaire h2 = new Horaire(10,45);
    Horaire h3 = new Horaire(9,15);

    @org.junit.jupiter.api.Test
    void compareTo() {
        assertEquals(-1,h1.compareTo(h2));
        assertEquals(1,h2.compareTo(h1));
        assertEquals(0,h1.compareTo(h3));
    }
}
