package gestion_transfert.acces_concurent;

import java.util.Arrays;

public class Banque  {
    final double[] compte;
    // constructeur
    public Banque(int i,double j) {
        compte = new  double[i+1];

        for (double k : compte){
            k=j;
        }
    }
    // somme solde
    public double soldetotal(){
        double a= Arrays.stream(compte).sum();
        return a;
    }

    void transfert(int i, int j , double somme ){
        compte[i]+=somme;
        compte[j]-=somme;
    }


    public static void main(String[] args) {
       //Simulation
        Banque banque = new Banque(100, 1000);
        for (int depuis = 0; depuis < 100; depuis ++) {
            Runnable r =  new transfert(banque,depuis,1000);
            new Thread(r).start();
        }
        System.out.println("all done !!!" + banque.soldetotal()+ " ");
    }
}
