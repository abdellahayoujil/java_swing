package devoir_libre;

class Montre {
    private int heure;
    private int minute;

    public Montre(int heure, int minute) {
        this.heure = heure;
        this.minute = minute;
    }

    public Montre(Montre autreMontre) {
        this.heure = autreMontre.heure;
        this.minute = autreMontre.minute;
    }

    public void afficherHeure() {
        System.out.println("Heure: " + heure + "h" + minute);
    }

    public void ajouterMinute() {
        minute++;
        if (minute == 60) {
            minute = 0;
            heure++;
        }
        if (heure == 24) {
            heure = 0;
        }
    }
}
