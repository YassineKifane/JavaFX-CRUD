package com.example.javafx_project.controllers;

import com.example.javafx_project.entities.Emission;
import com.example.javafx_project.services.EmissionService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class EmissionController {
    @FXML
    private TableView<Emission> EmissionTableView;

    private EmissionService EmissionService;

    private ObservableList<Emission> EmissionsList;

    public EmissionController() {
        EmissionService = new EmissionService();
    }

    @FXML
    private void initialize() {
        // Initialize the Emissions list
        //EmissionsList = FXCollections.observableArrayList(EmissionService.findAll());

        // Set the items of the table view to the Emissions list
        EmissionTableView.setItems(EmissionsList);

        // Configure table columns
        TableColumn<Emission, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Emission, String> titreColumn = new TableColumn<>("Titre");
        titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));

        TableColumn<Emission, Date> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Emission, Integer> dureeColumn = new TableColumn<>("Duree (min)");
        dureeColumn.setCellValueFactory(new PropertyValueFactory<>("duree"));

        TableColumn<Emission, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Emission, String> producerColumn = new TableColumn<>("Producer");
        producerColumn.setCellValueFactory(new PropertyValueFactory<>("producer"));


        // Add the columns to the table view
        EmissionTableView.getColumns().addAll(idColumn, titreColumn,dateColumn,dureeColumn,genreColumn,producerColumn);
    }
}
