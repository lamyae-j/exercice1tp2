package gestion_transfert.acces_concurent;

public class CompteBanque {
     int solde;

     public CompteBanque(int solde) {
          this.solde = solde;
     }

     public int getSolde() {
          return solde;
     }

     public int retirer(int somme){
          int a = this.solde-somme;
          return a;
     }


}
