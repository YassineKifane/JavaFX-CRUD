package com.example.javafx_project.controllers;

import com.example.javafx_project.entities.Producer;
import com.example.javafx_project.services.ProducerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProducerController implements Initializable {
    @FXML
    private TextField nameField;

    @FXML
    private TextField cinField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button addButton;

    private ProducerService producerService;

    public void setProducerService(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        producerService = new ProducerService();
    }





    @FXML
    private void handleAddButtonAction() {
        String name = nameField.getText();
        String cin = cinField.getText();
        String address = addressField.getText();
        int phoneNumber = Integer.parseInt(phoneNumberField.getText());

        Producer producer = new Producer();
        producer.setName(name);
        producer.setCIN(cin);
        producer.setAddress(address);
        producer.setPhoneNumber(phoneNumber);

        producerService.save(producer);

        clearFields();
    }

    private void clearFields() {
        nameField.clear();
        cinField.clear();
        addressField.clear();
        phoneNumberField.clear();
    }


}
