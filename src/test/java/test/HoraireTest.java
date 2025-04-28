package test;

import modele.Horaire;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
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
    Horaire h4 = new Horaire(0,30);

    @org.junit.jupiter.api.Test @Order(2)
    void compareTo() {
        assertEquals(-1,h1.compareTo(h2));
        assertEquals(1,h2.compareTo(h1));
        assertEquals(0,h1.compareTo(h3));
    }

    @org.junit.jupiter.api.Test @Order(1)
    void toMinutes() {
        assertEquals(555,h1.toMinutes());
        assertEquals(30,h4.toMinutes());
    }
}
