package devoir_libre;
import java.util.Scanner;

public class NombreDeChiffres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez un entier N: ");
        int N = scanner.nextInt();
        
        int nombreDeChiffres = String.valueOf(Math.abs(N)).length();

        
        System.out.println("Le nombre de chiffres de " + N + " est: " + nombreDeChiffres);
        
    }
}
