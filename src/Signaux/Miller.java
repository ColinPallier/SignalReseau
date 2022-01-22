package Signaux;

import java.util.ArrayList;

public class Miller implements Code{
    @Override
    public ArrayList<Courbe> getCourbe(String trame) {

        ArrayList<Courbe> retour = new ArrayList<>();
        boolean bitHaut = false;
        char bitPrecedent = ' ';
        int cpt = 0;
        int distance = 800/trame.length();
        int demiDistance = distance/2;

        for (char bit : trame.toCharArray()){

            if(bit == '0'){
                if (bitPrecedent == bit){
                    retour.add(new Courbe(cpt*distance,100,distance*cpt,550));
                    bitHaut = !bitHaut;
                }

                if (bitHaut){
                    retour.add(new Courbe(cpt*distance,100,(distance*cpt)+distance,100));
                }else{
                    retour.add(new Courbe(cpt*distance,550,(distance*cpt)+distance,550));
                }
            bitPrecedent = bit;
            }else{
                if (bitHaut){
                    retour.add(new Courbe(cpt*distance,100,(distance*cpt)+demiDistance,100));
                    retour.add(new Courbe((distance*cpt)+demiDistance,100,(distance*cpt)+demiDistance,550));
                    retour.add(new Courbe((distance*cpt)+demiDistance,550,(cpt*distance)+distance,550));
                    bitHaut = false;
                }else{
                    retour.add(new Courbe(cpt*distance,550,(distance*cpt)+demiDistance,550));
                    retour.add(new Courbe((distance*cpt)+demiDistance,550,(distance*cpt)+demiDistance,100));
                    retour.add(new Courbe((distance*cpt)+demiDistance,100,(cpt*distance)+distance,100));
                    bitHaut = true;
                }
                bitPrecedent = bit;
            }
            cpt++;
        }

        return retour;
    }
}
