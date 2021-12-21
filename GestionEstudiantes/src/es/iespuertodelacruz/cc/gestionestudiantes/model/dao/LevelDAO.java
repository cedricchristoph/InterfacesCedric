/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.LevelEntry;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Level entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Level entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Level> selectAll() {
        ArrayList<Level> levels = new ArrayList<Level>();
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                levels.add(new Level(rs.getInt(ID), rs.getString(NAME)));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            return levels;
        }
    }

    @Override
    public Level selectById(Integer id) {
        Level level = null;
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE + " WHERE id = " + id);
            while(rs.next())
                return new Level(rs.getInt(ID), rs.getString(NAME));
        } catch (SQLException e) {
            
        }
        return null;
    }
    
    
}
