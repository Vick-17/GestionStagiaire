package com.gestion.gestionstagiare;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Stagiaire {
    private StringProperty nom ;
    private StringProperty prenom;
    private IntegerProperty groupe;

    public Stagiaire(StringProperty nom, StringProperty prenom, IntegerProperty groupe) {
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
    }

    public Stagiaire(String nom, String prenom, int groupe) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.groupe = new SimpleIntegerProperty(groupe);
    }

    public Stagiaire(String nom, String prenom) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
    }

    public int getGroupe() {
        return groupe.get();
    }

    public IntegerProperty groupeProperty() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe.set(groupe);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }
}
