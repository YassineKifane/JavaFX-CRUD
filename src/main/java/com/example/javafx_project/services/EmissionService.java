package com.example.javafx_project.services;

import com.example.javafx_project.dao.EmissionDao;
import com.example.javafx_project.dao.impl.EmissionDaoImp;
import com.example.javafx_project.entities.Emission;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class EmissionService {
    private EmissionDao EmissionDao = new EmissionDaoImp();

    /*public List<Emission> findAll() {
        return EmissionDao.findAll();
    }*/

    public void save(Emission Emission) {

        EmissionDao.insert(Emission);

    }
    public void update(Emission Emission) {

        EmissionDao.update(Emission);

    }
    public void remove(Emission Emission) {
        EmissionDao.deleteById(Emission.getId());
    }


}
