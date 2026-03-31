package dao;

import db.DBConnection;
import model.Doctor;

import java.sql.*;
import java.util.*;

public class DoctorDAO {

    public void addDoctor(Doctor d) throws Exception {

        String sql = "INSERT INTO doctors(name,specialization) VALUES(?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.setString(2, d.getSpecialization());

            ps.executeUpdate();
        }
    }

    public List<Doctor> getAll() throws Exception {

        List<Doctor> list = new ArrayList<>();

        String sql = "SELECT * FROM doctors";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                list.add(new Doctor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        }
        return list;
    }
}