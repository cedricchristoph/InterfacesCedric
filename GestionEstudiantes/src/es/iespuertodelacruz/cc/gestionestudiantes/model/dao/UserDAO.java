/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;


import es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.UserEntry;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Level;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.MyDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author cedric
 */
public class UserDAO extends UserEntry implements CRUD<User, String> {

    MyDatabase db;
    
    public UserDAO() {
        db = new MyDatabase();
    }
    
    @Override
    public boolean insert(User entity) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + TABLE + " (" + USERNAME + ", " + PASSWORD + ", " + LEVEL + ") VALUES ('" + entity.getUsername() + "', '" + entity.getPassword() + "', " + entity.getLevel().getId() + ")";
            int affected = stmt.executeUpdate(sql);
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(User entity) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM " + TABLE + " WHERE " + USERNAME + " = '" + entity.getUsername() + "'";
            int affected = stmt.executeUpdate(sql);
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User entity) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE + " SET " + PASSWORD + " = '" + entity.getPassword() + "', " + LEVEL + " = " + entity.getLevel().getId() + " WHERE " + USERNAME + " = '" + entity.getUsername() + "'";
            int affected = stmt.executeUpdate(sql);
            return affected > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<User> selectAll() {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            return getResultList(rs);
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    @Override
    public User selectById(String id) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE + " WHERE " + USERNAME + " = '" + id + "'");
            return getSingleResult(rs);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public User getSingleResult(ResultSet rs) {
        LevelDAO levelDao = new LevelDAO();
        try {
            while(rs.next()) {
                Integer levelId = rs.getInt(LEVEL);
                if (levelId == null) continue;
                Level level = levelDao.selectById(levelId);
                if (level == null) continue;
                return new User(rs.getString(USERNAME), rs.getString(PASSWORD), level);
            }
        } catch (SQLException ex) {
  
        }
        return null;
    }

    @Override
    public List<User> getResultList(ResultSet rs) {
        LevelDAO levelDao = new LevelDAO();
        ArrayList<User> users = new ArrayList<User>();
        try {
            while (rs.next()) {
                Integer levelId = rs.getInt(LEVEL);
                if (levelId == null) continue;
                Level level = levelDao.selectById(levelId);
                if (level == null) continue;
                users.add(new User(rs.getString(USERNAME), rs.getString(PASSWORD), level));
            }
            return users;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
