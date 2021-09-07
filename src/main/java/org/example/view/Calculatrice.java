package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import org.example.model.Calculateur;

public class Calculatrice {


    private final Integer LARGEUR_COLUMN = 50;
    private final Integer LARGEUR_COLUMN_EGAL = 100;

    private VBox main;
    private HBox affichage;
    private HBox clickable;
    private TextField affichageText;
    private GridPane gridPane;

    private Calculateur calculateur;

    public Calculatrice(){
        setupView();
    }


    private void setupView() {
        main = new VBox();
        calculateur = new Calculateur();
        setupAffichage();
        setupGrilleChiffresEtOperateurs();
        setupChiffres();
        setupOperateurs();
        setupEgalEtReset();
    }

    public Parent getRoot(){
        return main;
    }
    private void setupAffichage() {
        affichage = new HBox();
        affichageText = new TextField("");
        affichage.getChildren().add(affichageText);
        main.getChildren().add(affichage);
    }

    private void setupGrilleChiffresEtOperateurs(){
        clickable = new HBox();

        gridPane = new GridPane();
        gridPane.setPadding( new Insets(10) );
        clickable.getChildren().add(gridPane);

        main.getChildren().add(clickable);
    }

    private void setupChiffres() {


        BoutonChiffre un = new BoutonChiffre("1", calculateur, affichageText);
        BoutonChiffre deux = new BoutonChiffre("2", calculateur, affichageText);
        BoutonChiffre trois = new BoutonChiffre("3", calculateur, affichageText);
        BoutonChiffre quatre = new BoutonChiffre("4", calculateur, affichageText);
        BoutonChiffre cinq = new BoutonChiffre("5", calculateur, affichageText);
        BoutonChiffre six = new BoutonChiffre("6", calculateur, affichageText);
        BoutonChiffre sept = new BoutonChiffre("7", calculateur, affichageText);
        BoutonChiffre huit = new BoutonChiffre("8", calculateur, affichageText);
        BoutonChiffre neuf = new BoutonChiffre("9", calculateur, affichageText);
        BoutonChiffre zero = new BoutonChiffre("0", calculateur, affichageText);
        BoutonChiffre point = new BoutonChiffre(".", calculateur, affichageText);


        gridPane.add(sept, 1, 0);
        gridPane.add(huit, 2, 0);
        gridPane.add(neuf, 3, 0);
        gridPane.add(quatre, 1, 1);
        gridPane.add(cinq, 2, 1);
        gridPane.add(six, 3, 1);
        gridPane.add(un, 1, 2);
        gridPane.add(deux, 2, 2);
        gridPane.add(trois, 3, 2);
        gridPane.add(zero, 1, 3);
        gridPane.add(point, 2, 3);
    }

    private void setupOperateurs(){
        BoutonOperateur addition = new BoutonOperateur("+", calculateur, affichageText);
        BoutonOperateur soustraction = new BoutonOperateur("-", calculateur, affichageText);
        BoutonOperateur multiplication = new BoutonOperateur("*", calculateur, affichageText);
        BoutonOperateur division = new BoutonOperateur("/", calculateur, affichageText);
        BoutonOperateur modulo = new BoutonOperateur("%", calculateur, affichageText);

        gridPane.add(modulo, 3, 3);
        gridPane.add(division, 4,0);
        gridPane.add(multiplication, 4,1);
        gridPane.add(soustraction, 4,2);
        gridPane.add(addition, 4, 3);
    }

    private void setupEgalEtReset(){
        EgallOperateur egall = new EgallOperateur( calculateur, affichageText);
        BoutonReset resetBouton = new BoutonReset(calculateur, affichageText);
        VBox egalEtResetVBox = new VBox();
        egalEtResetVBox.getChildren().addAll(resetBouton, egall);
        egalEtResetVBox.setPadding(new Insets(10));
        egalEtResetVBox.setVgrow(resetBouton, Priority.ALWAYS);
        egalEtResetVBox.setVgrow(egall, Priority.ALWAYS);
        clickable.getChildren().add(egalEtResetVBox);
    }
}
