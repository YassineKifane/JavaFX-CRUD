package com.example.javafx_project.services;

import com.example.javafx_project.dao.ProducerDao;
import com.example.javafx_project.dao.impl.ProducerDaoImp;
import com.example.javafx_project.entities.Producer;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProducerService {
    private ProducerDao producerDao = new ProducerDaoImp();

    public List<Producer> findAll() {
        return producerDao.findAll();
    }

    public void save(Producer producer) {
        producerDao.insert(producer);
    }

    public void update(Producer producer) {
        producerDao.update(producer);
    }

    public void remove(Producer producer) {
        producerDao.deleteById(producer.getId());
    }


    public void readFromTextFileAndInsertInDatabase(String path){
        producerDao.readFromTextFileAndInsertInDatabase(path);
    }

    public void readFromJsonFileAndInsertInDatabase(String path){
        producerDao.readFromJsonFileAndInsertInDatabase(path);
    }

    public void readFromStyleSheetAndInsertInDatabase(String path) {
        producerDao.readFromStyleSheetAndInsertInDatabase(path);
    }

    public void writingOutPut(ObservableList<Producer> list){
        producerDao.writingOutPut(list);
    }

    public void writingJsonFile(ObservableList<Producer> list){
        producerDao.writingJsonFile(list);
    }
    public void writingExcelFile(ObservableList<Producer> list) throws Exception{
        producerDao.writingExcelFile(list);
    }



}
