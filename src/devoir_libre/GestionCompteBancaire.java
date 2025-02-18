package devoir_libre;

import java.util.Scanner;

public class GestionCompteBancaire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez le solde initial du compte: ");
        double soldeInitial = scanner.nextDouble();
        Account compte = new Account(soldeInitial);

        int option; 

        do {
            System.out.println("\n1. Déposer de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Ajouter des intérêts");
            System.out.println("4. Voir le solde");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option: ");
            
            option = scanner.nextInt(); 

            switch (option) {
                case 1:
                    System.out.print("Entrez le montant à déposer: ");
                    double montantDepot = scanner.nextDouble();
                    compte.deposer(montantDepot);
                    break;
                case 2:
                    System.out.print("Entrez le montant à retirer: ");
                    double montantRetrait = scanner.nextDouble();
                    compte.retirer(montantRetrait);
                    break;
                case 3:
                    System.out.print("Entrez le taux d'intérêt: ");
                    double taux = scanner.nextDouble();
                    compte.ajouter_Interet(taux);
                    break;
                case 4:
                    System.out.println("Solde actuel: " + compte.getBalance());
                    break;
                case 5:
                    System.out.println("Merci d'utiliser notre service bancaire. Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        } while (option != 5);

        scanner.close();}}
