/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.RecetaEntry;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.TipoReceta;
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
public class RecetaTipoDAO extends RecetaEntry.RecetaTipoEntry implements CRUD<TipoReceta, Integer>{

    private MyDatabase db;
    
    public RecetaTipoDAO() {
        db = new MyDatabase();
    }
    
    @Override
    public boolean insert(TipoReceta entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(TipoReceta entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(TipoReceta entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoReceta> selectAll() {
        List<TipoReceta> tipos = new ArrayList<TipoReceta>();
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next())
                tipos.add(new TipoReceta(rs.getInt(ID), rs.getString(TIPO)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return tipos;
        }
    }

    @Override
    public TipoReceta selectById(Integer id) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE + " WHERE " + ID + " = " + id);
            while(rs.next())
                return new TipoReceta(rs.getInt(ID), rs.getString(TIPO));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
