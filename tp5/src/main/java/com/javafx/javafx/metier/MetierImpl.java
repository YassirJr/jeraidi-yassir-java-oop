package com.javafx.javafx.metier;


import com.javafx.javafx.models.Departement;
import com.javafx.javafx.models.Professeur;
import com.javafx.javafx.singleton.SingletonConnexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier {
    private final Connection connection = SingletonConnexionDB.getConnexion();

    @Override
    public List<Professeur> getAllProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM professeurs p"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                professeurs.add(extractProfesseurFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;
    }

    @Override
    public List<Professeur> searchProfesseurs(String keyword) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM professeurs p LEFT JOIN departements d ON p.id = d.id " +
                            "WHERE p.nom LIKE ? OR p.prenom LIKE ? OR p.cin LIKE ?"
            );
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            ps.setString(3, searchPattern);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                professeurs.add(extractProfesseurFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;
    }

    @Override
    public void addProfesseur(Professeur professeur) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO professeurs (nom, prenom, cin, adresse, telephone, email, date_recrutement , departement_id) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ? , ?)"
            );
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getCin());
            ps.setString(4, professeur.getAdresse());
            ps.setString(5, professeur.getTelephone());
            ps.setString(6, professeur.getEmail());
            ps.setDate(7, new java.sql.Date(professeur.getDateRecrutement().getTime()));
            ps.setInt(8 , professeur.getDepartementId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteProfesseur(int idProf) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM professeurs WHERE id = ?"
            );
            ps.setInt(1, idProf);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateProfesseur(Professeur professeur) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE professeurs SET nom=?, prenom=?, cin=?, adresse=?, telephone=?, email=?, " +
                            "date_recrutement=? , departement_id=? WHERE id=?"
            );
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getCin());
            ps.setString(4, professeur.getAdresse());
            ps.setString(5, professeur.getTelephone());
            ps.setString(6, professeur.getEmail());
            ps.setDate(7, new java.sql.Date(professeur.getDateRecrutement().getTime()));
            ps.setInt(8, professeur.getDepartementId());
            ps.setInt(9, professeur.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addDepartement(Departement departement) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO departements (nom) VALUES (?)"
            );
            ps.setString(1, departement.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Departement> getAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM departements");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Departement d = new Departement();
                d.setId(rs.getInt("id"));
                d.setNom(rs.getString("nom"));
                departements.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return departements;
    }

    @Override
    public void deleteDepartement(int idDepart) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM departements WHERE id = ?"
            );
            ps.setInt(1, idDepart);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateDepartement(Departement departement) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE departements SET nom=? WHERE id=?"
            );
            ps.setString(1, departement.getNom());
            ps.setInt(2, departement.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Professeur> getProfesseursByDepartement(int idDepart) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM professeurs p JOIN departements d ON p.id = d.id " +
                            "WHERE d.id = ?"
            );
            ps.setInt(1, idDepart);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                professeurs.add(extractProfesseurFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;
    }

    private Professeur extractProfesseurFromResultSet(ResultSet rs) throws SQLException {
        Professeur p = new Professeur();
        p.setId(rs.getInt("id"));
        p.setNom(rs.getString("nom"));
        p.setPrenom(rs.getString("prenom"));
        p.setCin(rs.getString("cin"));
        p.setAdresse(rs.getString("adresse"));
        p.setTelephone(rs.getString("telephone"));
        p.setEmail(rs.getString("email"));
        p.setDepartementId(rs.getInt("departement_id"));
        p.setDateRecrutement(rs.getDate("date_recrutement"));
        return p;
    }
}