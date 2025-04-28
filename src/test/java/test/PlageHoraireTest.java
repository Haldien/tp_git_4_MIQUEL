package test;

import modele.Horaire;
import modele.PlageHoraire;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class PlageHoraireTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("setup");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("teardown");
    }

    Horaire startHoraire1 = new Horaire(8, 15);
    Horaire endHoraire1 = new Horaire(13, 30);
    Horaire startHoraire2 = new Horaire(10, 45);
    Horaire endHoraire2 = new Horaire(11, 45);
    Horaire startHoraire3 = new Horaire(13, 0);
    Horaire endHoraire3 = new Horaire(21, 0);
    Horaire startHoraire4 = new Horaire(9, 30);
    Horaire endHoraire4 = new Horaire(10, 30);

    PlageHoraire plageHoraire1 = new PlageHoraire(startHoraire1, endHoraire1);
    PlageHoraire plageHoraire2 = new PlageHoraire(startHoraire2, endHoraire2);
    PlageHoraire plageHoraire3 = new PlageHoraire(startHoraire3, endHoraire3); // PAS VALIDE
    PlageHoraire plageHoraire4 = new PlageHoraire(startHoraire4, endHoraire4);


    @org.junit.jupiter.api.Test
    void duree(){
        assertTrue(plageHoraire1.duree().compareTo(new Horaire(5, 15)) == 0);
        assertTrue(plageHoraire3.duree().compareTo(new Horaire(8, 0)) == 0);
        assertTrue(plageHoraire4.duree().compareTo(new Horaire(1, 0)) == 0);
    }

}
