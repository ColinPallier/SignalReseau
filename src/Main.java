import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String tramBinnaire;
    static int code;

    public static void main(String[] args) {

        affichageTramBianaire();

        while (!verifBinaire()){
            affichageTramBianaire();
        }

       affichageCode();

        while (!verifCode()){
            affichageCode();
        }

        SwingUtilities.invokeLater(() -> {
            new FenetreAffichage(tramBinnaire,code);
        });




    }

    public static boolean verifBinaire(){
        boolean estBinaire = true;
        for (int i = 0 ; i<tramBinnaire.length();i++){
            if (tramBinnaire.charAt(i) != '0' && tramBinnaire.charAt(i) != '1' ){
                estBinaire = false;
            }
        }
        return estBinaire;
    }

    public static void affichageTramBianaire(){
        System.out.print("\nVeuillez rentrer la trame bianire a traduire : ");
        tramBinnaire = scanner.nextLine();
    }

    public static boolean verifCode(){
        boolean estValide = true;
        if (code < 1 || code > 5){
            estValide = false;
        }
        return estValide;
    }


    public static void affichageCode(){
        System.out.println("\nVers quel code voulez-vous le traduire ?  ");
        System.out.println("1) NRZ");
        System.out.println("2) NRZI");
        System.out.println("3) Manchester");
        System.out.println("4) Manchester différanciel");
        System.out.println("5) Miller");
        System.out.print("Choix : ");
        code = scanner.nextInt();
    }


}
