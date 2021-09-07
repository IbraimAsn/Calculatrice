package org.example.view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.model.Calculateur;

public class EgallOperateur extends Button {

    private Calculateur calculateur;
    private TextField affichageText;

    public EgallOperateur(Calculateur calculateur, TextField affichageText){
        super("=");
        this.setOnMouseClicked(new LanceurCalcul());
        this.affichageText = affichageText;
        this.calculateur = calculateur;
        this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(Double.MAX_VALUE);
    }

    private class LanceurCalcul implements EventHandler<Event> {
        @Override
        public void handle(Event event){
            try {
                calculateur.calculer();
                affichageText.setText(calculateur.getResultat());
                calculateur.reset();
            }catch (Exception ex){
                affichageText.setText("ERREUR");
            }
        }
    }
}
