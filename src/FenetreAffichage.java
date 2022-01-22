import Signaux.Courbe;
import Signaux.NRZ;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FenetreAffichage extends JFrame {
    public FenetreAffichage(String tramBinaire,int code){
        super("Reseau");
        setResizable(false);
        setSize(800,600);
        setLayout(new GridLayout(1,1));

        PanelAffichage panel = new PanelAffichage(tramBinaire,code);
        this.add(panel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
