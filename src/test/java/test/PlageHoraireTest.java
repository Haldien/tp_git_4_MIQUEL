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

    @org.junit.jupiter.api.Test
    void compareToSuccesion() {
        // Plages succesives
        Horaire Horaire1Debut = new Horaire(9, 0);  // 9h00
        Horaire Horaire1Fin = new Horaire(10, 0);   // 10h00
        PlageHoraire plage1 = new PlageHoraire(Horaire1Debut, Horaire1Fin);

        Horaire Horaire2Debut = new Horaire(10, 0);  // 10h00
        Horaire Horaire2Fin = new Horaire(11, 0);    // 11h00
        PlageHoraire plage2 = new PlageHoraire(Horaire2Debut, Horaire2Fin);

        assertEquals(-1, plage1.compareTo(plage2));  // plage1 précède plage2
        assertEquals(1, plage2.compareTo(plage1));   // plage2 suit plage1
    }

    @org.junit.jupiter.api.Test
    void compareToChevauchement() {
        // Plages qui se chevauchent
        Horaire Horaire3Debut = new Horaire(9, 0);  // 9h00
        Horaire Horaire3Fin = new Horaire(10, 0);   // 10h00
        PlageHoraire plage3 = new PlageHoraire(Horaire3Debut, Horaire3Fin);

        Horaire Horaire4Debut = new Horaire(9, 30);  // 9h30
        Horaire Horaire4Fin = new Horaire(10, 30);   // 10h30
        PlageHoraire plage4 = new PlageHoraire(Horaire4Debut, Horaire4Fin);

        assertEquals(0, plage3.compareTo(plage4));  // Les plages se chevauchent
        assertEquals(0, plage4.compareTo(plage3));  // Les plages se chevauchent
    }

    @org.junit.jupiter.api.Test
    void compareToEgalite() {
        // Plages égales
        Horaire Horaire5Debut = new Horaire(9, 0);  // 9h00
        Horaire Horaire5Fin = new Horaire(10, 0);   // 10h00
        PlageHoraire plage5 = new PlageHoraire(Horaire5Debut, Horaire5Fin);

        Horaire Horaire6Debut = new Horaire(9, 0);  // 9h00
        Horaire Horaire6Fin = new Horaire(10, 0);   // 10h00
        PlageHoraire plage6 = new PlageHoraire(Horaire6Debut, Horaire6Fin);

        assertEquals(0, plage5.compareTo(plage6));  // Les plages sont égales
        assertEquals(0, plage6.compareTo(plage5));  // Les plages sont égales
    }

    @org.junit.jupiter.api.Test
    void compareToInclusion() {
        // Plage 1 est incluse dans Plage 2
        Horaire Horaire7Debut = new Horaire(9, 0);  // 9h00
        Horaire Horaire7Fin = new Horaire(10, 0);   // 10h00
        PlageHoraire plage7 = new PlageHoraire(Horaire7Debut, Horaire7Fin);

        Horaire Horaire8Debut = new Horaire(9, 15);  // 9h15
        Horaire Horaire8Fin = new Horaire(9, 45);   // 9h45
        PlageHoraire plage8 = new PlageHoraire(Horaire8Debut, Horaire8Fin);

        assertEquals(0, plage7.compareTo(plage8));  // plage7 contient plage8
        assertEquals(0, plage8.compareTo(plage7)); // plage8 est incluse dans plage7

    }


}
