package com.example.javafx_project.controllers;

import com.example.javafx_project.entities.Producer;
import com.example.javafx_project.services.ProducerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExportController implements Initializable {

    @FXML
    private Button addJson;

    @FXML
    private Button addExcel;

    @FXML
    private Button addText;

    private ProducerService producerService;

    private ObservableList<Producer> producerList;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        producerService = new ProducerService();
        loadProducers();
    }

    @FXML
    private void WritingExcelF() throws Exception{
        producerService.writingExcelFile(producerList);
    }
    @FXML
    private void WritingJsonF() {
        producerService.writingJsonFile(producerList);
    }
    @FXML
    private void WritingTextF() {
        producerService.writingOutPut(producerList);
    }

    private void loadProducers() {
        List<Producer> producers = producerService.findAll();
        producerList = FXCollections.observableArrayList(producers);
    }
}
