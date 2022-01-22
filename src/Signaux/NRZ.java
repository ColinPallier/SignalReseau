package Signaux;


import java.util.ArrayList;

public class NRZ implements Code{

    @Override
    public ArrayList<Courbe> getCourbe(String trame) {

        ArrayList<Courbe> retour = new ArrayList<>();
        char bitPrecedent = trame.charAt(0);
        int cpt = 0;
        int distance = 800/trame.length();

        for(char bit : trame.toCharArray()){

            if (bitPrecedent != bit){
                retour.add(new Courbe(cpt*distance,100,distance*cpt,550));
            }

            if (bit == '1'){
                retour.add(new Courbe(cpt*distance,100,distance+(distance*cpt),100));
                bitPrecedent = bit;
                cpt++;
            }

            if (bit == '0'){
                retour.add(new Courbe(cpt*distance,550,distance+(distance*cpt),550));
                bitPrecedent = bit;
                cpt++;
            }

        }

        return retour;
    }
}
