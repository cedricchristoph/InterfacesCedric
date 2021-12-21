/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Receta;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cedric
 */
public class RecetaDAOTest {
    
    public RecetaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insert method, of class RecetaDAO.
     
    @Test
    public void testInsert() {
        System.out.println("insert");
        Receta entity = null;
        RecetaDAO instance = new RecetaDAO();
        boolean expResult = false;
        boolean result = instance.insert(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RecetaDAO.
     
    @Test
    public void testDelete() {
        System.out.println("delete");
        Receta entity = null;
        RecetaDAO instance = new RecetaDAO();
        boolean expResult = false;
        boolean result = instance.delete(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class RecetaDAO.
     
    @Test
    public void testUpdate() {
        System.out.println("update");
        Receta entity = null;
        RecetaDAO instance = new RecetaDAO();
        boolean expResult = false;
        boolean result = instance.update(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAll method, of class RecetaDAO.
     */
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        RecetaDAO instance = new RecetaDAO();
        Integer expResult = 6;
        List<Receta> list = instance.selectAll();
        Integer result = list.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of selectById method, of class RecetaDAO.
     */
    @Test
    public void testSelectById() {
        System.out.println("selectById");
        Integer id = 1;
        RecetaDAO instance = new RecetaDAO();
        Integer expResult = id;
        Receta result = instance.selectById(id);
        assertEquals(expResult, result.getId());
    }
    
}
