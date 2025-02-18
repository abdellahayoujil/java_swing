package devoir_libre;

class Account {
    private double solde;

    public Account() {
        solde = 0;
    }

    public Account(double soldeInitial) {
        solde = soldeInitial;
    }

    public double getBalance() {
        return solde;
    }

    public void deposer(double montant) {
        solde += montant;
        System.out.println(montant + " déposé. Solde actuel: " + solde);
    }

    public void retirer(double montant) {
        if (montant <= solde) {
            solde -= montant;
            System.out.println(montant + " retiré. Solde actuel: " + solde);
        } else {
            System.out.println("Fonds insuffisants!");
        }
    }

    public void ajouter_Interet(double taux) {
    	if(taux > 0) {
    		solde *= (1+taux); 
    	}else {
    		System.out.println("le taux doit etre positif");
    	}
        
    }
}
