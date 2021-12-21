/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Level;
import es.iespuertodelacruz.cc.gestionestudiantes.model.utils.MyDatabase;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cedric
 */
public class LevelDAOTest {
    
    private ArrayList<Level> levels;
    
    public LevelDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MyDatabase.cargarDriverMysql();
        levels = new ArrayList<Level>();
        Level alumno = new Level(0, "Alumno");
        Level profesor = new Level(1, "Profesor");
        levels.add(alumno);
        levels.add(profesor);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class LevelDAO.
     
    @Test
    public void testInsert() {
        System.out.println("insert");
        Level entity = null;
        LevelDAO instance = new LevelDAO();
        boolean expResult = false;
        boolean result = instance.insert(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of delete method, of class LevelDAO.
     
    @Test
    public void testDelete() {
        System.out.println("delete");
        Level entity = null;
        LevelDAO instance = new LevelDAO();
        boolean expResult = false;
        boolean result = instance.delete(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of update method, of class LevelDAO.
     
    @Test
    public void testUpdate() {
        System.out.println("update");
        Level entity = null;
        LevelDAO instance = new LevelDAO();
        boolean expResult = false;
        boolean result = instance.update(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of selectAll method, of class LevelDAO.
     */
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        LevelDAO instance = new LevelDAO();
        List<Level> expResult = levels;
        List<Level> result = instance.selectAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of selectById method, of class LevelDAO.
     */
    @Test
    public void testSelectById() {
        System.out.println("selectById");
        Integer id = 0;
        LevelDAO instance = new LevelDAO();
        Level expResult = levels.get(0);
        Level result = instance.selectById(id);
        assertEquals(expResult, result);
    }
    
}
