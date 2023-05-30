package com.example.javafx_project.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.javafx_project.entities.Producer;
import com.example.javafx_project.services.ProducerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ImportController implements Initializable {

    @FXML
    private Button importTextButton;

    @FXML
    private Button importJsonButton;

    @FXML
    private Button importExcelButton;

    private ProducerService producerService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        producerService = new ProducerService();
    }

    @FXML
    private void importTextFile() {
        producerService.readFromTextFileAndInsertInDatabase("src/main/resources/files/inputData.txt");
    }

    @FXML
    private void importJsonFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("JSON Files", "*.json"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                List<Producer> producers = producerService.readFromJsonFile(inputStream);
                // Process the imported producers as needed
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void importExcelFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Excel Files", "*.xlsx"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                List<Producer> producers = producerService.readFromExcelFile(file);
                // Process the imported producers as needed
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setProducerService(ProducerService producerService) {
        this.producerService = producerService;
    }
}
