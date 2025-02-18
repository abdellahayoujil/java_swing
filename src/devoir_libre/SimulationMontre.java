package devoir_libre;



public class SimulationMontre {
    public static void main(String[] args) {
        Montre montre1 = new Montre(13, 45);
        montre1.afficherHeure();
        
        montre1.ajouterMinute();
        montre1.afficherHeure();
    }
}


Exercice 3:
Classe Personne et Montre avec interactions entre elles :

Classe Montre : Cette classe représente une montre qui peut être portée par une seule personne.
Classe Personne : Cette classe représente une personne qui peut porter une montre.
Nous allons aussi mettre en place des mécanismes pour garantir qu'une montre ne soit portée que par une seule personne et que la personne puisse demander l'heure d'une autre.

java
Copier
Modifier
// Classe représentant une Montre
class Montre {
    private int heure;
    private int minute;
    private Personne personne;

    // Constructeur pour initialiser la montre avec heure et minute
    public Montre(int heure, int minute) {
        this.heure = heure;
        this.minute = minute;
        this.personne = null;  // Aucun propriétaire au départ
    }

    // Méthode pour afficher l'heure
    public String afficherHeure() {
        return heure + "h" + minute;
    }

    // Méthode pour ajouter une minute à l'heure
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

    // Méthode pour attribuer la montre à une personne
    public boolean porterPar(Personne p) {
        if (this.personne == null) {
            this.personne = p;
            return true;
        }
        return false;  // La montre est déjà portée par quelqu'un d'autre
    }

    // Méthode pour enlever la montre
    public void enlever() {
        this.personne = null;
    }

    // Retourne la personne qui porte la montre
    public Personne getPersonne() {
        return personne;
    }
}

// Classe représentant une Personne
class Personne {
    private String nom;
    private Montre montre;

    public Personne(String nom) {
        this.nom = nom;
        this.montre = null;
    }

    // La personne demande l'heure à une autre personne
    public String demanderHeure(Personne autrePersonne) {
        if (autrePersonne.montre != null) {
            return autrePersonne.montre.afficherHeure();
        } else {
            return ""; // La personne n'a pas de montre, retourne une chaîne vide
        }
    }

    // Méthode pour faire porter une montre à la personne
    public boolean porterMontre(Montre m) {
        if (this.montre == null) {
            this.montre = m;
            return m.porterPar(this);
        }
        return false;  // La personne porte déjà une montre
    }

    // Méthode pour enlever la montre
    public void enleverMontre() {
        if (this.montre != null) {
            this.montre.enlever();
            this.montre = null;
        }
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Getter pour la montre
    public Montre getMontre() {
        return montre;
    }
}

public class Test {
    public static void main(String[] args) {
        Montre montre1 = new Montre(13, 45);
        Montre montre2 = new Montre(8, 30);

        Personne personne1 = new Personne("Alice");
        Personne personne2 = new Personne("Bob");

        // Faire porter une montre à une personne
        personne1.porterMontre(montre1);
        System.out.println(personne1.getNom() + " porte une montre: " + personne1.getMontre().afficherHeure());

        // Bob demande l'heure à Alice
        System.out.println("Bob demande l'heure à Alice: " + personne1.demanderHeure(personne2));

        // Essayer de faire porter la montre 2 à Alice, mais elle porte déjà une montre
        boolean success = personne1.porterMontre(montre2);
        System.out.println("Alice a-t-elle pu porter la montre 2 ? " + (success ? "Oui" : "Non"));

        // Alice enlève sa montre
        personne1.enleverMontre();
        System.out.println(personne1.getNom() + " a enlevé sa montre.");
    }
}
Explications :
La classe Montre représente une montre, avec des méthodes pour afficher l'heure et ajouter des minutes. Une montre peut être portée par une personne, et cette relation est gérée dans la classe.
La classe Personne permet à une personne de porter une montre, de demander l'heure d'une autre personne et de gérer l'ajout ou l'enlèvement d'une montre.
Pour garantir qu'une montre ne soit portée que par une seule personne, la méthode porterPar() dans la classe Montre vérifie si la montre est déjà portée avant de l'attribuer à une personne.
Exercice 4:
1. Classe Employé et Calcul du Salaire :
java
Copier
Modifier
// Classe représentant un Employé
class Employe {
    private String nom;
    private String matricule;
    private double indiceSalarial;
    static double valeurSalaire = 1500; // Valeur de base pour calculer le salaire

    // Constructeur
    public Employe(String nom, String matricule, double indiceSalarial) {
        this.nom = nom;
        this.matricule = matricule;
        this.indiceSalarial = indiceSalarial;
    }

    // Méthode pour calculer le salaire
    public double calculerSalaire() {
        return indiceSalarial * valeurSalaire;
    }

    // Afficher les informations de l'employé
    public void afficherInfos() {
        System.out.println("Nom: " + nom);
        System.out.println("Matricule: " + matricule);
        System.out.println("Salaire: " + calculerSalaire());
    }
}

public class TestEmploye {
    public static void main(String[] args) {
        Employe employe1 = new Employe("Alice", "E001", 3.5);
        employe1.afficherInfos();
    }
}
Explications :
La classe Employe contient les informations de base d'un employé, y compris son nom, matricule et indice salarial.
La méthode calculerSalaire calcule le salaire en multipliant l'indice salarial par la valeur de base.
2. Sous-classe pour les Responsables :
java
Copier
Modifier
// Sous-classe représentant un Responsable
class Responsable extends Employe {
    private Employe[] subordonnes;

    public Responsable(String nom, String matricule, double indiceSalarial, Employe[] subordonnes) {
        super(nom, matricule, indiceSalarial);
        this.subordonnes = subordonnes;
    }

    // Méthode pour afficher les inférieurs directs
    public void afficherInferieursDirects() {
        System.out.println("Inférieurs directs de " + super.nom + ":");
        for (Employe e : subordonnes) {
            System.out.println("- " + e.nom);
        }
    }

    // Méthode pour afficher tous les inférieurs (directs et indirects)
    public void afficherInferieursIndirection() {
        afficherInferieursDirects();
        for (Employe e : subordonnes) {
            if (e instanceof Responsable) {
                ((Responsable) e).afficherInferieursIndirection();
            }
        }
    }
}
3. Sous-classe des Commerciaux :
java
Copier
Modifier
// Sous-classe représentant un Commercial
class Commercial extends Employe {
    private double ventesDernierMois;

    public Commercial(String nom, String matricule, double indiceSalarial, double ventesDernierMois) {
        super(nom, matricule, indiceSalarial);
        this.ventesDernierMois = ventesDernierMois;
    }

    // Mettre à jour les ventes
    public void mettreAJourVentes(double nouvellesVentes) {
        this.ventesDernierMois = nouvellesVentes;
    }

    // Calculer le salaire avec commission
    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + ventesDernierMois * 0.05; // 5% des ventes
    }
}
import java.util.List;

class PersonnelEntreprise {
    private List<Employe> employes;

    public PersonnelEntreprise(List<Employe> employes) {
        this.employes = employes;
    }

    // Calculer la somme des salaires à verser
    public double calculerTotalSalaires() {
        double total = 0;
        for (Employe e : employes) {
            total += e.calculerSalaire();
        }
        return total;
    }
}