/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.AuthorizationEntry;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Authorization;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Level;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.AuthorizedSection;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.MyDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cedric
 */
public class AuthorizationsDAO extends AuthorizationEntry implements CRUD<Authorization, Integer>{

    MyDatabase db;
    
    public AuthorizationsDAO() {
        db = new MyDatabase();
    }
    
    @Override
    public boolean insert(Authorization entity) {
        try (Connection conn = db.getConnection()) {
            String sql = "INSERT INTO " +TABLE + " (" + LEVEL + ", " + AUTHORIZED + ") VALUES "
                    + "(" + entity.getLevel().getId() + ", " + entity.getSection().getIdentifier() + ")";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int affected = stmt.executeUpdate();
            return affected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Authorization entity) {
        try (Connection conn = db.getConnection()) {
            String sql = "DELETE FROM " + TABLE + " WHERE " + ID + " = " + entity.getId();
            PreparedStatement stmt = conn.prepareStatement(sql);
            int affected = stmt.executeUpdate();
            return affected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Authorization entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Authorization> selectAll() {
        try (Connection conn = db.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
            return getResultList(stmt.executeQuery());
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Authorization selectById(Integer id) {
        try (Connection conn = db.getConnection()) {
            String sql = "SELECT * FROM " + TABLE + " WHERE " + ID + " = ?1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return getSingleResult(stmt.executeQuery());
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public List<Authorization> selectLevelAuthorizations(Level level) {
        try (Connection conn = db.getConnection()) {
            String sql = "SELECT * FROM " + TABLE + " WHERE " + LEVEL + " = " + level.getId();
            PreparedStatement stmt = conn.prepareStatement(sql);
            //stmt.setInt(1, level);
            List<Authorization> results = getResultList(stmt.executeQuery());
            results.forEach(a -> a.setLevel(level));
            return results;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Authorization getSingleResult(ResultSet rs) {
        try {
            LevelDAO dao = new LevelDAO();
            while (rs.next()) {
                Authorization a = new Authorization();
                a.setId(rs.getInt(ID));
                a.setLevel(dao.selectById(rs.getInt(LEVEL)));
                a.setSection(AuthorizedSection.toAuthorizedSection(rs.getInt(AUTHORIZED)));
                return a;
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    @Override
    public List<Authorization> getResultList(ResultSet rs) {
        List<Authorization> authorizations = new ArrayList<>();
        try {
            LevelDAO dao = new LevelDAO();
            while (rs.next()) {
                Authorization a = new Authorization();
                a.setId(rs.getInt(ID));
                a.setSection(AuthorizedSection.toAuthorizedSection(rs.getInt(AUTHORIZED)));
                authorizations.add(a);
            }
            return authorizations;
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
}
