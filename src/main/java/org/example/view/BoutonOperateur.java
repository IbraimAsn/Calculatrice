package org.example.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.model.Calculateur;

public class BoutonOperateur extends Button {

    public BoutonOperateur(String operateur, Calculateur calculateur, TextField affichageText){
        super(operateur);
        this.setOnMouseClicked(event -> calculateur.addOperateur(operateur));
        affichageText.setText(calculateur.getCalcul());
        this.setMaxWidth(Double.MAX_VALUE);
    }
}
