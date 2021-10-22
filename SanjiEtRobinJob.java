package gestion_transfert.acces_concurent;

public class SanjiEtRobinJob  implements Runnable {
    CompteBanque compte ;
    float R;
    public void run(){
        int somme =100;
        for (int i=495; i<502;i++){
            R=DemandeDeRetrait(i);
            if (R ==0){
                System.out.println("Pas assez d'argent pour "+Thread.currentThread().getName() + "\n");
            }
            else{
                System.out.println(Thread.currentThread().getName() + "   est sur le point de retirer.\n");
            }
        }

        try {
            Thread.currentThread().sleep(500);
            System.out.println(Thread.currentThread().getName() + "  reveillé.");
            compte.retirer(somme);
            System.out.println(Thread.currentThread().getName() + "  à compléter le retrait");

            System.out.println( this.compte.getSolde() + "\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
   // un compte est dis a decouvert si on depasse la limite du solde disponible

    public int DemandeDeRetrait(int somme){
         if( this.compte.solde - somme >0){
             return 1;
         }
        return 0;
    }


    public static void  main(String [] args){
        SanjiEtRobinJob T= new SanjiEtRobinJob();

        T.compte= new CompteBanque(500);
        Thread TA= new Thread(T);
        Thread TB = new Thread(T);


        TA.start();
        TB.start();


    }
}
// concurrence sur la meme ressource
// il peut y avoir des chevachement
// calcul partagé entre 2 threads
// ....