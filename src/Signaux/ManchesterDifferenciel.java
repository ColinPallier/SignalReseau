package Signaux;

import java.util.ArrayList;

public class ManchesterDifferenciel implements Code{
    @Override
    public ArrayList<Courbe> getCourbe(String trame) {

        ArrayList<Courbe> retour = new ArrayList<>();
        boolean bitHaut =false;
        int cpt = 0;
        int distance = 800/trame.length();
        int demiDistance = distance/2;


        for (char bit : trame.toCharArray()){

            if (bit == '0'){
                retour.add(new Courbe(cpt*distance,100,distance*cpt,550));
                if (bitHaut){
                    retour.add(new Courbe(cpt*distance,550,(distance*cpt)+demiDistance,550));
                    retour.add(new Courbe((distance*cpt)+demiDistance,550,(distance*cpt)+demiDistance,100));
                    retour.add(new Courbe((distance*cpt)+demiDistance,100,(cpt*distance)+distance,100));
                    bitHaut = true;
                    cpt++;
                }else{
                    retour.add(new Courbe(cpt*distance,100,(distance*cpt)+demiDistance,100));
                    retour.add(new Courbe((distance*cpt)+demiDistance,100,(distance*cpt)+demiDistance,550));
                    retour.add(new Courbe((distance*cpt)+demiDistance,550,(cpt*distance)+distance,550));
                    bitHaut = false;
                    cpt++;
                }
            }else{
                if (bitHaut){
                    retour.add(new Courbe(cpt*distance,100,(distance*cpt)+demiDistance,100));
                    retour.add(new Courbe((distance*cpt)+demiDistance,100,(distance*cpt)+demiDistance,550));
                    retour.add(new Courbe((distance*cpt)+demiDistance,550,(cpt*distance)+distance,550));
                    cpt++;
                    bitHaut = false;
                }else{
                    retour.add(new Courbe(cpt*distance,550,(distance*cpt)+demiDistance,550));
                    retour.add(new Courbe((distance*cpt)+demiDistance,550,(distance*cpt)+demiDistance,100));
                    retour.add(new Courbe((distance*cpt)+demiDistance,100,(cpt*distance)+distance,100));
                    cpt++;
                    bitHaut = true;
                }
            }

        }

        return retour;
    }
}
