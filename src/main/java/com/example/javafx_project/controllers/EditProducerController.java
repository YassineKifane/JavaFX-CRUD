package com.example.javafx_project.controllers;

import com.example.javafx_project.entities.Producer;
import com.example.javafx_project.services.ProducerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProducerController implements Initializable {
    private Producer producer;
    private boolean updateRequired = false;

    @FXML
    private TextField nameField;
    @FXML
    private TextField cinField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNumberField;

    private ProducerService producerService; // Assuming you have the ProducerService injected or instantiated properly

    public void setProducerService(ProducerService producerService) {
        this.producerService = producerService;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
        populateFields();
    }

    public boolean isUpdateRequired() {
        return updateRequired;
    }

    public Producer getUpdatedProducer() {
        updateProducer();
        return producer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void populateFields() {
        if (producer != null) {
            nameField.setText(producer.getName());
            cinField.setText(producer.getCIN());
            addressField.setText(producer.getAddress());
            phoneNumberField.setText(String.valueOf(producer.getPhoneNumber()));
        }
    }

    private void updateProducer() {
        if (producer != null) {
            producer.setName(nameField.getText());
            producer.setCIN(cinField.getText());
            producer.setAddress(addressField.getText());
            producer.setPhoneNumber(Integer.parseInt(phoneNumberField.getText()));
            updateRequired = true;
        }
    }

    @FXML
    private void saveChanges() {
        updateProducer();
        producerService.update(producer); // Assuming you have the update method in your ProducerService implementation
        closeForm();
    }

    private void closeForm() {
        // Close the form or perform any necessary cleanup
        nameField.getScene().getWindow().hide();
    }
}

