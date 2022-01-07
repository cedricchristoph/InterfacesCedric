/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.LevelEntry;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Authorization;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Level;
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
public class LevelDAO extends LevelEntry implements CRUD<Level, Integer>{
    
    MyDatabase db;
    
    public LevelDAO() {
        db = new MyDatabase();
    }

    @Override
    public boolean insert(Level entity) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + TABLE + " (" + NAME + ") VALUES ('" + entity.getName() + "')";
            System.out.println(sql);
            int affected = stmt.executeUpdate(sql);
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Level entity) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM " + TABLE + " WHERE " + ID + " = " + entity.getId();
            int affected = stmt.executeUpdate(sql);
            return affected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Level entity) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE + " SET " + NAME + " = '" + entity.getName() + "' WHERE " + ID + " = " + entity.getId();
            int affected = stmt.executeUpdate(sql);
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Level> selectAll() {
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
    public Level selectById(Integer id) {
        Level level = null;
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE + " WHERE id = " + id);
            return getSingleResult(rs);
        } catch (SQLException e) {
            
        }
        return null;
    }

    @Override
    public Level getSingleResult(ResultSet rs) {
        try {
            while (rs.next()) {
                AuthorizationsDAO dao = new  AuthorizationsDAO();
                Level level = new Level();
                level.setId(rs.getInt(ID));
                level.setName(rs.getString(NAME));
                level.setAuthorizations((ArrayList<Authorization>) dao.selectLevelAuthorizations(level));
                return level;
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    @Override
    public List<Level> getResultList(ResultSet rs) {
        List<Level> levels = new ArrayList<>();
        try {
            while (rs.next()) {
                AuthorizationsDAO dao = new  AuthorizationsDAO();
                Level level = new Level();
                level.setId(rs.getInt(ID));
                level.setName(rs.getString(NAME));
                level.setAuthorizations((ArrayList<Authorization>) dao.selectLevelAuthorizations(level));
                levels.add(level);
            }
            return levels;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
}
