module com.example.javafx_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    requires poi.ooxml;
    requires poi;
    requires gson;
    requires json.simple;
    requires com.fasterxml.jackson.databind;


    opens com.example.javafx_project to javafx.fxml;
    exports com.example.javafx_project;
    exports com.example.javafx_project.dao.impl;
    exports com.example.javafx_project.controllers;
    opens com.example.javafx_project.dao.impl to javafx.fxml;
    opens com.example.javafx_project.controllers to javafx.fxml;
    opens com.example.javafx_project.entities to javafx.base, com.fasterxml.jackson.databind;

}