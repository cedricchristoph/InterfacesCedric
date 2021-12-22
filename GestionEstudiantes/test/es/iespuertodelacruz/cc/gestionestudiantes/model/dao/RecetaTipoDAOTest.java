/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.TipoReceta;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cedric
 */
public class RecetaTipoDAOTest {
    
    public RecetaTipoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insert method, of class RecetaTipoDAO.
     
    @Test
    public void testInsert() {
        System.out.println("insert");
        TipoReceta entity = null;
        RecetaTipoDAO instance = new RecetaTipoDAO();
        boolean expResult = false;
        boolean result = instance.insert(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RecetaTipoDAO.
     
    @Test
    public void testDelete() {
        System.out.println("delete");
        TipoReceta entity = null;
        RecetaTipoDAO instance = new RecetaTipoDAO();
        boolean expResult = false;
        boolean result = instance.delete(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class RecetaTipoDAO.
     
    @Test
    public void testUpdate() {
        System.out.println("update");
        TipoReceta entity = null;
        RecetaTipoDAO instance = new RecetaTipoDAO();
        boolean expResult = false;
        boolean result = instance.update(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAll method, of class RecetaTipoDAO.
     */
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        RecetaTipoDAO instance = new RecetaTipoDAO();
        Integer expected = 4;
        List<TipoReceta> list = instance.selectAll();
        Integer result = list.size();
        assertEquals(expected, result);
    }

    /**
     * Test of selectById method, of class RecetaTipoDAO.
     */
    @Test
    public void testSelectById() {
        System.out.println("selectById");
        Integer id = 1;
        RecetaTipoDAO instance = new RecetaTipoDAO();
        TipoReceta expResult = new TipoReceta(id, "Entrante", "");
        TipoReceta result = instance.selectById(id);
        assertEquals(expResult.getId(), result.getId());
    }
    
}
