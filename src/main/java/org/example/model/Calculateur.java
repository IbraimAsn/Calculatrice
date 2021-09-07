package org.example.model;

import java.util.Arrays;

public class Calculateur {

    private StringBuilder calcul;
    private String resultat;
    private Double valeurUn;
    private Double valeurDeux;
    private String operateur;

    public Calculateur(){
        calcul = new StringBuilder();
        resultat = "";
        valeurUn = 0.0;
        valeurDeux = 0.0;
        operateur = "z";
    }

    private final String OPERATEURS_REGEX = "[+/*\\-%]";
    private final String OPERATEURS = "+-/*%";

    public void reset() {
        calcul = new StringBuilder();
    }

    public void addOperand(String operand) {
        if (validerOperand(operand)) {
            calcul.append(operand);
        }
    }

    private boolean validerOperand(String operand) {
        return "0123456789.".contains(operand)
                && operand.length() == 1;
    }

    public void addOperateur(String operateur) {
        if (validerOperateur(operateur)) {
            calcul.append(operateur);
        }
    }

    private boolean validerOperateur(String operateur) {
        return OPERATEURS.contains(operateur) && operateur.length() == 1;
    }


    public void calculer() throws Exception {
        preparerCalcul();
        switch (operateur) {
            case "+":
                resultat = String.valueOf(valeurUn + valeurDeux);
                break;
            case "-":
                resultat = String.valueOf(valeurUn - valeurDeux);
                break;
            case "/":
                resultat = String.valueOf(valeurUn / valeurDeux);
                break;
            case "*":
                resultat = String.valueOf(valeurUn * valeurDeux);
                break;
            case "%":
                resultat = String.valueOf(valeurUn % valeurDeux);
                break;
            default:
                throw new Exception("Erreur lors du calcul");
        }
    }

    private void preparerCalcul() throws Exception {
        if (validerCalcul(calcul.toString())) {
            String[] temp = calcul.toString().split(OPERATEURS_REGEX);
            valeurUn = Double.parseDouble(temp[0]);
            valeurDeux = Double.parseDouble(temp[1]);
            operateur = trouverOperateur(calcul.toString());
        }
    }

    private boolean validerCalcul(String calcul) {
        //verif si il y a plusieurs separateur décimaux.
    	if( ! verifLesSeparateursDecimaux(calcul) ) {
    		return false;
    	}
        if (!calculContientUnOperateur(calcul)) {
            return false;
        }

        if (!calculContientDeuxOperand(calcul)) {
            return false;
        }
        return true;

    }
    
    private boolean verifLesSeparateursDecimaux(String calcul) {
    	int premierePosition = calcul.indexOf(".");
    	int dernierePosition = calcul.lastIndexOf(".");
    	if(dernierePosition == premierePosition+1) {
    		return false;
    	}else if(dernierePosition == calcul.length()-1) {
    		return false;
    	}else {
    		return true;
    	}
    	
    }

    private boolean calculContientUnOperateur(String calcul) {
        for (String s : OPERATEURS.split("")) {
            if (calcul.contains(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean calculContientDeuxOperand(String calcul) {
        String[] temp = calcul.toString().split(OPERATEURS_REGEX);
        if (temp.length == 2) {
            return true;
        } else {
            return false;
        }
    }

    private String trouverOperateur(String calcul) throws Exception {
        String output = "";
        for (String s : OPERATEURS.split("")) {
            if (calcul.contains(s)) {
                output = s;
            }
        }
        return output;

    }

    public String getCalcul() {
        return calcul.toString();
    }

    public String getResultat() {
        return resultat;
    }

}
