package com.example.javafx_project.dao;

import com.example.javafx_project.entities.Producer;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;

public interface ProducerDao {
    void insert(Producer producer);

    void update(Producer producer);

    void deleteById(Integer id);

    Producer findById(Integer id);

    List<Producer> findAll();

    List<Producer> readFromTextFile(FileReader fileReader);

    void readFromDatabaseToTextFile();

    void readFromStyleSheetAndInsertInDatabase(String path);
    void readFromTextFileAndInsertInDatabase(String path);
    void readFromJsonFileAndInsertInDatabase(String path);

    void writingOutPut(ObservableList<Producer> list);

    void writingJsonFile(ObservableList<Producer> list);
    void writingExcelFile(ObservableList<Producer> list) throws Exception;




}
