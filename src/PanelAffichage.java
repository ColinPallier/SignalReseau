import Signaux.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelAffichage extends JPanel {
    static int longeurTramBianaire;
    static String tramBinaire;
    private Code code;


    public PanelAffichage(String tramBinaireEntree,int code){
        longeurTramBianaire = tramBinaireEntree.length();
        tramBinaire = tramBinaireEntree;

        switch (code){
            case 1:
                this.code = new NRZ();
                break;
            case 2:
                this.code = new NRZI();
                break;
            case 3:
                this.code = new Manchester();
                break;
            case 4:
                this.code = new ManchesterDifferenciel();
                break;
            default:
                this.code = new Miller();
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);

        drawGrille(g2d);
        drawCourbe(g2d);
    }

    private void drawGrille(Graphics2D g2d){

        g2d.drawLine(0,100, this.getWidth(),100);
        g2d.drawLine(0,(100+550)/2, this.getWidth(),(100+550)/2);
        g2d.drawLine(0,550, this.getWidth(),550);

        Font currentFont = g2d.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
        g2d.setFont(newFont);


        for (int i=0;i<longeurTramBianaire;i++){


            int longueurType = (this.getWidth()/longeurTramBianaire);
            int interval = longueurType*i;

            int somme = ((longueurType/2)+interval);

            g2d.drawString(String.valueOf(tramBinaire.charAt(i)),somme,50);
            g2d.drawLine(interval,0,interval,550);
        }

    }

    private void drawCourbe(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        BasicStroke line = new BasicStroke(4.0f);
        g2d.setStroke(line);

        ArrayList<Courbe> al = code.getCourbe(tramBinaire);


        for (Courbe c: al) {
            g2d.drawLine(c.getX1(),c.getY1(),c.getX2(),c.getY2());
        }

    }
}
