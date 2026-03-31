package dao;

import db.DBConnection;
import model.Patient;

import java.sql.*;
import java.util.*;

public class PatientDAO {

    public void addPatient(Patient p) throws Exception {

        String sql = "INSERT INTO patients(name,phone) VALUES(?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getPhone());

            ps.executeUpdate();
        }
    }

    public List<Patient> getAll() throws Exception {

        List<Patient> list = new ArrayList<>();

        String sql = "SELECT * FROM patients";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                list.add(new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        }
        return list;
    }
}