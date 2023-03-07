package com.gestion.gestionstagiare;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.Collection;
import java.util.Collections;

public class HelloController {
    @FXML
    private TextField inputNom = null;
    @FXML
    private TextField inputPrenom = null;
    @FXML
    private TableColumn<Stagiaire, String> coloneNom = null;
    @FXML
    private TableColumn<Stagiaire, String> colonePrenom = null;
    @FXML
    private TableColumn<Stagiaire, Number> coloneGroupe = null;
    @FXML
    private TableView<Stagiaire> tableStagiaire = null;
    private ObservableList<Stagiaire> stagiaires = FXCollections.observableArrayList();
    @FXML
    private TextField nbrGroup = null;
    @FXML
    private TextField nbrStagiaireGroupe = null;

    public void SatgiairePlusOne() {
        tableStagiaire.setItems(stagiaires);
        String nom = inputNom.getText();
        String prenom = inputPrenom.getText();
        stagiaires.add(new Stagiaire(nom, prenom));
        coloneNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colonePrenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
    }

    public void delete(ActionEvent action) {
        Stagiaire stagiaireSelctioner = tableStagiaire.getSelectionModel().getSelectedItem();
        stagiaires.remove(stagiaireSelctioner);
    }

    public void formationGroupe(ActionEvent action) {
        int nbrStagiaireInscrit = tableStagiaire.getItems().size();
        int nbrDeGroupe = Integer.parseInt(nbrGroup.getText());
        int nbrStagiaireDansGroupe = Integer.parseInt(nbrStagiaireGroupe.getText());

        Stagiaire getStagiaire = (Stagiaire) tableStagiaire.getItems();
        getStagiaire.setGroupe(nbrStagiaireInscrit);
        coloneGroupe.setCellValueFactory(cellData -> cellData.getValue().groupeProperty());

/*        if (nbrStagiaireInscrit < nbrDeGroupe * nbrStagiaireDansGroupe) {
        }*/
        ObservableList<ObservableList<Stagiaire>> groupes = FXCollections.observableArrayList();
        Collections.shuffle(stagiaires);

        for (int i = 0; i < nbrDeGroupe; i++) {
            ObservableList<Stagiaire> groupe = FXCollections.observableArrayList();

            for (int j = 0; j < nbrStagiaireDansGroupe; j++) {
                Stagiaire stagiaire = stagiaires.get(i * nbrStagiaireDansGroupe + j);
                stagiaire.setGroupe(i + 1);
                groupe.add(stagiaire);
            }

            groupes.add(groupe);
        }
        tableStagiaire.setItems(FXCollections.emptyObservableList());
        stagiaires.clear();

        for (ObservableList<Stagiaire> groupe : groupes) {
            stagiaires.addAll(groupe);
        }

        coloneNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colonePrenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        coloneGroupe.setCellValueFactory(cellData -> cellData.getValue().groupeProperty());
    }

}