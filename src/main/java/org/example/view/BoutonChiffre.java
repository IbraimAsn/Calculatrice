package org.example.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.model.Calculateur;

public class BoutonChiffre extends Button {

    public BoutonChiffre(String nbr, Calculateur calculateur, TextField affichageText){
        super(nbr);
        this.setOnMouseClicked( e -> {
            calculateur.addOperand(nbr);
            affichageText.setText(calculateur.getCalcul());
            System.out.println(nbr);
            System.out.println(calculateur.getCalcul());
        });
        this.setMaxWidth(Double.MAX_VALUE);
    }

}
