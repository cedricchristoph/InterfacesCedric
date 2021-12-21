/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import static es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.LevelEntry.ID;
import static es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.LevelEntry.NAME;
import static es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.LevelEntry.SELECT_ALL;
import static es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.LevelEntry.TABLE;
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
            String sql = "UPDATE " + TABLE + " SET " + PASSWORD + " = '" + entity.getPassword() + "', " + LEVEL + " = " + entity.getLevel().getId();
            int affected = stmt.executeUpdate(sql);
            return affected > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<User> selectAll() {
        LevelDAO levelDao = new LevelDAO();
        ArrayList<User> users = new ArrayList<User>();
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Integer levelId = rs.getInt(LEVEL);
                if (levelId == null) continue;
                Level level = levelDao.selectById(levelId);
                if (level == null) continue;
                users.add(new User(rs.getString(USERNAME), rs.getString(PASSWORD), level));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            return users;
        }
    }

    @Override
    public User selectById(String id) {
        LevelDAO levelDao = new LevelDAO();
        User user = null;
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE + " WHERE " + USERNAME + " = '" + id + "'");
            while(rs.next()) {
                Integer levelId = rs.getInt(LEVEL);
                if (levelId == null) continue;
                Level level = levelDao.selectById(levelId);
                if (level == null) continue;
                user = new User(rs.getString(USERNAME), rs.getString(PASSWORD), level);
            }
        } catch (SQLException e) {
            
        } finally {
            return user;
        }
    }
    
}
