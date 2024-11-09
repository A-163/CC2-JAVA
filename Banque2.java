class Client {
    private String nom;
    private String ville;

    public Client(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public String toString() {
        return nom + " de " + ville;
    }
}

class Compte {
    private double solde;
    private double tauxInteret;

    public Compte(double solde, double tauxInteret) {
        this.solde = solde;
        this.tauxInteret = tauxInteret;
    }

    public double getSolde() {
        return solde;
    }

    public void appliquerInteret() {
        solde += solde + tauxInteret;
    }

    @Override
    public String toString() {
        return String.format("Compte: %.2f francs", solde);
    }
}

class Banque {
    private Client client1;
    private Client client2;
    private Compte comptePriveClient1;
    private Compte compteEpargneClient1;
    private Compte comptePriveClient2;
    private Compte compteEpargneClient2;

    public Banque() {
        client1 = newClient("Pedro", "Geneve");
        client2 = newClient("Alexandra", "Lausanne");
        
        comptePriveClient1 = newCompte(1000.0, 0.01);
        compteEpargneClient1 = newCompte(2000.0, 0.02);
        comptePriveClient2 = newCompte(3000.0, 0.01);
        compteEpargneClient2 = newCompte(4000.0, 0.02);
    }
    
    public void bouclerComptes() {
        comptePriveClient1.appliquerInteret();
        compteEpargneClient1.appliquerInteret();
        comptePriveClient2.appliquerInteret();
        compteEpargneClient2.appliquerInteret();
    }
    
    public void afficherCompteApresInteret() {
        System.out.println("Donnees apres le bouclement des comptes:");
        afficherInfosClient(client1,comptePriveClient1,compteEpargneClient1);
        afficherInfosClient(client2,comptePriveClient2,compteEpargneClient2);
    } 
}