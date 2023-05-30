package com.example.javafx_project.dao;

import com.example.javafx_project.entities.Emission;

public interface EmissionDao {
    void insert(Emission emission);

    void update(Emission emission);

    void deleteById(Integer id);

    Emission findById(Integer id);
    //List<Emission> findAll();




}
