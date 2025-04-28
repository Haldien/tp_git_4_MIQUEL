package modele;

public class Horaire {

    private int chHeure;
    private int chQuartHeure;

    public Horaire(int parHeure, int parQuartHeure) {
        chHeure = parHeure;
        chQuartHeure = parQuartHeure;
    }

    public int toMinutes(){
        return chHeure * 60 + chQuartHeure;
    }

    public int getHeure(){
        return chHeure;
    }

    public int getQuartHeure(){
        return chQuartHeure;
    }

    public void setHeure(int parHeure){
        chHeure = parHeure;
    }

    public void setQuartHeure(int parQuartHeure){
        chQuartHeure = parQuartHeure;
    }

    public String toString(){
        return chHeure + "h" + chQuartHeure;
    }

    // pas demandée dans l'énoncé
    public boolean estValide(){
        if(0<=chHeure && 0<=chQuartHeure && chHeure<=23 && chQuartHeure <= 59){
            if(chQuartHeure%15==0){ // Doit être un quart d'heure
                return true;
            }
        }
        return false;
    }

    // pas demandée dans l'énoncé
    public int compareTo(Horaire h2){
        if (this.toMinutes()<h2.toMinutes()){
            return -1;
        }
        else if (this.toMinutes()>h2.toMinutes()){
            return 1;
        }
        return 0;

    }

}
