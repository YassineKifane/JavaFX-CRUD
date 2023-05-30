package com.example.javafx_project.controllers;

import com.example.javafx_project.entities.Producer;
import com.example.javafx_project.services.ProducerService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProducerController implements Initializable {
    @FXML
    private TableView<Producer> producerTableView;

    @FXML
    private TableColumn<Producer, Integer> idColumn;

    @FXML
    private TableColumn<Producer, String> nameColumn;

    @FXML
    private TableColumn<Producer, String> cinColumn;

    @FXML
    private TableColumn<Producer, String> addressColumn;

    @FXML
    private TableColumn<Producer, Integer> phoneNumberColumn;

    @FXML
    private TableColumn<Producer, Button> editColumn;

    @FXML
    private TableColumn<Producer, Button> deleteColumn;

    private ProducerService producerService;
    private ObservableList<Producer> producerList;

    public void setProducerService(ProducerService producerService) {
        this.producerService = producerService;
    }

    @FXML
    private void openProducerForm() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/views/ProducerForm.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    @FXML
    private void openExportFile() {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/views/ExportChoice.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void openImportFile() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ImportChoice.fxml"));
            Parent parent = loader.load();

            ImportController importController = loader.getController();
            importController.setProducerService(producerService);

            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    @FXML
    private void handleLogout() {
        // Perform logout actions, such as clearing session data
        // If you have a separate login window or scene, show it
        showLoginWindow();
        // Close the current window (assuming the logout button is in a different window)
        Stage currentStage = (Stage) producerTableView.getScene().getWindow();
        currentStage.close();
    }

    private void showLoginWindow() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        producerService = new ProducerService();
        startAutoRefresh();
        loadProducers();
        setupTableView();
    }

    private void loadProducers() {
        List<Producer> producers = producerService.findAll();
        producerList = FXCollections.observableArrayList(producers);
    }

    private void setupTableView() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        cinColumn.setCellValueFactory(new PropertyValueFactory<>("CIN"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        editColumn.setCellFactory(createEditButtonCellFactory());

        deleteColumn.setCellFactory(createDeleteButtonCellFactory());

        producerTableView.setItems(producerList);
    }

    @FXML
    private void openEditProducerForm(Producer producer) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/EditProducer.fxml"));
            Parent parent = loader.load();
            EditProducerController editProducerController = loader.getController();
            editProducerController.setProducer(producer);
            editProducerController.setProducerService(producerService);
            System.out.println(producer);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Callback<TableColumn<Producer, Button>, TableCell<Producer, Button>> createEditButtonCellFactory() {
        return new Callback<>() {
            @Override
            public TableCell<Producer, Button> call(TableColumn<Producer, Button> column) {
                return new TableCell<>() {
                    private final Button editButton = new Button("Edit");

                    {
                        editButton.setOnAction(event -> {
                            Producer producer = getTableView().getItems().get(getIndex());
                            System.out.println(producer);
                            openEditProducerForm(producer);

                            // Handle edit button action
                            // You can open a dialog or switch to an edit view
                        });
                    }

                    @Override
                    protected void updateItem(Button item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            setGraphic(editButton);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        };
    }

    private Callback<TableColumn<Producer, Button>, TableCell<Producer, Button>> createDeleteButtonCellFactory() {
        return new Callback<>() {
            @Override
            public TableCell<Producer, Button> call(TableColumn<Producer, Button> column) {
                return new TableCell<>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction(event -> {
                            Producer producer = getTableView().getItems().get(getIndex());
                            producerService.remove(producer);
                            producerTableView.getItems().remove(producer);
                        });
                    }

                    @Override
                    protected void updateItem(Button item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            setGraphic(deleteButton);
                        } else {
                            setGraphic(null);
                        }
                    }
                };
            }
        };
    }

    private void startAutoRefresh() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            refreshTableView();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    private void refreshTableView() {
        List<Producer> producers = producerService.findAll();
        producerTableView.getItems().clear();
        producerTableView.getItems().addAll(producers);
    }
}
