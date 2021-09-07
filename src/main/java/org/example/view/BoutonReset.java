package org.example.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.model.Calculateur;

public class BoutonReset extends Button {

    public BoutonReset(Calculateur calculateur, TextField affichage){
        super("Reset");
        this.setOnMouseClicked(e -> {
            calculateur.reset();
            affichage.setText("");
        });
        this.setMaxHeight(Double.MAX_VALUE);
        this.setMaxWidth(Double.MAX_VALUE);

    }
}
