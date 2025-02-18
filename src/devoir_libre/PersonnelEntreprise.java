package devoir_libre;
import java.util.List;

class PersonnelEntreprise1 {
    private List<Employe> employes;

    public PersonnelEntreprise1(List<Employe> employes) {
        this.employes = employes;
    }

    public double calculerTotalSalaires() {
        double total = 0;
        for (Employe e : employes) {
            total += e.calculerSalaire();
        }
        return total;
    }
}
