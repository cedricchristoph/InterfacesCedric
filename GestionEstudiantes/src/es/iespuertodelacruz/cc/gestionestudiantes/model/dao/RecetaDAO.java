/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.contracts.RecetaEntry;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.TipoReceta;
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
public class RecetaDAO extends RecetaEntry implements CRUD<Receta, Integer>{

    private MyDatabase db;
    
    public RecetaDAO() {
        db = new MyDatabase();
    }
    
    @Override
    public boolean insert(Receta entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Receta entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Receta entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Receta> selectAll() {
        List<Receta> recetas = new ArrayList<Receta>();
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            UserDAO userDao = new UserDAO();
            RecetaTipoDAO tipoDao = new RecetaTipoDAO();
            while (rs.next()) {
                User autor = userDao.selectById(rs.getString(AUTOR));
                TipoReceta tipo = tipoDao.selectById(rs.getInt(TIPO));
                Receta receta = new Receta();
                receta.setId(rs.getInt(ID));
                receta.setTitulo(rs.getString(TITULO));
                receta.setAutor(autor);
                receta.setTipo(tipo);
                receta.setIngredientes(rs.getString(INGREDIENTES));
                receta.setPasos(rs.getString(PASOS));
                receta.setComensales(rs.getInt(COMENSALES));
                receta.setCalorias(rs.getFloat(CALORIAS));
                receta.setTiempoPreparacion(rs.getInt(TIEMPO_PREPARACION));
                receta.setImageURL(rs.getString(IMAGEN));
                recetas.add(receta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return recetas;
        }
    }

    @Override
    public Receta selectById(Integer id) {
        try (Connection conn = db.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            UserDAO userDao = new UserDAO();
            RecetaTipoDAO tipoDao = new RecetaTipoDAO();
            while(rs.next()) {
                User autor = userDao.selectById(rs.getString(AUTOR));
                TipoReceta tipo = tipoDao.selectById(rs.getInt(TIPO));
                Receta receta = new Receta();
                receta.setId(rs.getInt(ID));
                receta.setTitulo(rs.getString(TITULO));
                receta.setAutor(autor);
                receta.setTipo(tipo);
                receta.setIngredientes(rs.getString(INGREDIENTES));
                receta.setPasos(rs.getString(PASOS));
                receta.setComensales(rs.getInt(COMENSALES));
                receta.setCalorias(rs.getFloat(CALORIAS));
                receta.setTiempoPreparacion(rs.getInt(TIEMPO_PREPARACION));
                receta.setImageURL(rs.getString(IMAGEN));
                return receta;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
