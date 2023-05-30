package com.example.javafx_project.dao.impl;



import com.example.javafx_project.dao.EmissionDao;
import com.example.javafx_project.entities.Emission;

import java.sql.*;

public class EmissionDaoImp implements EmissionDao {

    private Connection conn= DB.getConnection();

    @Override
    public void insert(Emission emission) {

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO emissions (titre,date,duree,genre,producer) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, emission.getTitre());
            ps.setDate(2, new java.sql.Date(emission.getDate().getTime()));
            ps.setInt(3, emission.getDuree());
            ps.setString(4, emission.getGenre());
            ps.setString(4, emission.getProducer());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);

                    emission.setId(id);
                }

                DB.closeResultSet(rs);
            } else {
                System.out.println("Aucune ligne renvoyée");
            }
        } catch (SQLException e) {
            System.err.println("problème d'insertion d'un département");;
        } finally {
            DB.closeStatement(ps);
        }

    }

    @Override
    public void update(Emission emission) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "UPDATE emissions SET titre = ?, date = ?, duree = ?, genre = ?, producer = ? WHERE id = ?");

            ps.setString(1, emission.getTitre());
            ps.setDate(2, new java.sql.Date(emission.getDate().getTime()));
            ps.setInt(3, emission.getDuree());
            ps.setString(4, emission.getGenre());
            ps.setString(5,emission.getProducer());
            ps.setInt(6, emission.getId());


            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("problème de mise à jour d'emission");;
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM emissions WHERE id = ?");

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("problème de suppression d'emission");;
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Emission findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM emissions  WHERE id = ?");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Emission emission = instantiateEmission(rs);

                return emission;
            }

            return null;
        } catch (SQLException e) {
            System.err.println("problème de requête pour trouver l'emission'");
            return null;
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }



    private Emission instantiateEmission(ResultSet rs) throws SQLException {
        Emission emission = new Emission();

        emission.setId(rs.getInt("id"));
        emission.setTitre(rs.getString("titre"));
        emission.setDate(new java.util.Date(rs.getTimestamp("date").getTime()));
        emission.setDuree(rs.getInt("duree"));
        emission.setProducer(rs.getString("producer"));

        return emission;
    }


}