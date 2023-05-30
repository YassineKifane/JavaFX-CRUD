package com.example.javafx_project.entities;


import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Date;


    public class Emission implements Serializable{
        private static final long serialVersionUID = 1L;
        private IntegerProperty id;
        private StringProperty titre;
        private ObjectProperty<Date> date;
        private IntegerProperty duree;
        private StringProperty genre;
        private StringProperty producer;

        public Emission(int id, String titre, Date date, int duree, String genre, String producer) {
            this.id = new SimpleIntegerProperty(id);
            this.titre = new SimpleStringProperty(titre);
            this.date = new SimpleObjectProperty<>(date);
            this.duree = new SimpleIntegerProperty(duree);
            this.genre = new SimpleStringProperty(genre);
            this.producer = new SimpleStringProperty(producer);
        }

        public Emission(String titre, String dateString, int duree, String genre, String producer) {
        }

        public Emission() {

        }

        public IntegerProperty idProperty() {
            return id;
        }

        public int getId() {
            return id.get();
        }

        public StringProperty titreProperty() {
            return titre;
        }

        public String getTitre() {
            return titre.get();
        }

        public ObjectProperty<Date> dateProperty() {
            return date;
        }

        public Date getDate() {
            return date.get();
        }

        public IntegerProperty dureeProperty() {
            return duree;
        }

        public int getDuree() {
            return duree.get();
        }

        public StringProperty genreProperty() {
            return genre;
        }

        public String getGenre() {
            return genre.get();
        }

        public StringProperty producerProperty() {
            return producer;
        }

        public String getProducer() {
            return producer.get();
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public void setDate(Date date) {
            this.date.set(date);
        }

        public void setDuree(int duree) {
            this.duree.set(duree);
        }

        public void setTitre(String titre) {
            this.titre.set(titre);
        }

        public void setProducer(String producer) {
            this.producer.set(producer);
        }

        public void setGenre(String genre) {
            this.genre.set(genre);
        }

        @Override
        public String toString() {
            return "Emission{" +
                    "id=" + id +
                    ", titre=" + titre +
                    ", date=" + date +
                    ", duree=" + duree +
                    ", genre=" + genre +
                    ", producer=" + producer +
                    '}';
        }
    }
