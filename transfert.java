package gestion_transfert.acces_concurent;

//import acces_concurent.Banque;

import java.util.Random;

public class transfert implements Runnable {

   public void run(){}
   public transfert(Banque banque, int j , double somme ){
        Random random = new Random();
        int nb;
        nb = random.nextInt(101);

        banque.compte[nb] += + somme;
        banque.compte[j]-=somme;
    }


}
