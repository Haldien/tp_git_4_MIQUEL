package modele;

public class PlageHoraire implements Comparable<PlageHoraire> {

    // final : constant; static : associé à la classe et non à un objet particulier
    private final static int DUREE_MIN = 30; // durée min : 30 minutes, arbitraire
    private Horaire chHoraireDebut;
    private Horaire chHoraireFin;

    public PlageHoraire(Horaire parHoraireDebut, Horaire parHoraireFin) {

        chHoraireDebut = parHoraireDebut;
        chHoraireFin = parHoraireFin;

    }

    public String toString(){
        return "Debut : " + chHoraireDebut + ", Fin : " +chHoraireFin + ", Duree : " + this.duree();
    }

    public boolean estValide(){
        if (chHoraireDebut.estValide() && chHoraireFin.estValide()){
            if(chHoraireFin.toMinutes() >= chHoraireDebut.toMinutes() + DUREE_MIN){ // Non seulement l'horaire de fin doit être plus grande que l'horaire de début, il faut aussi prendre en compte la durée minimum
                return true;
            }
        }
        return false;
    }

    public Horaire duree(){ // On considère que c'est une Horaire. On pourrait peut-être le faire avec un int

        Horaire duree = new Horaire(0, 0);

        int enMinutes = chHoraireFin.toMinutes() - chHoraireDebut.toMinutes();

        duree.setHeure(enMinutes/60);
        duree.setQuartHeure(enMinutes%60);

        return duree;

    }

    public int compareTo(PlageHoraire p2){
        if (this.chHoraireFin.compareTo(p2.chHoraireDebut) <= 0){ // comparaison non-stricte : pour les cas comme 9H0-10h30 et 10h30-11h30. Ces plages ont 10h30 en commun mais la premmière précède la deuxième
            return -1;
        }
        else if (this.chHoraireDebut.compareTo(p2.chHoraireFin) >= 0){
            return 1;
        }
        return 0;
    }



}
