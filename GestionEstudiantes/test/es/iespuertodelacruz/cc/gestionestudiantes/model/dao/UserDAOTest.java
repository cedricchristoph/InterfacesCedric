/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.dao;

import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.Level;
import es.iespuertodelacruz.cc.gestionestudiantes.model.entity.User;
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
public class UserDAOTest {
    
    private ArrayList<Level> levels;
    private ArrayList<User> expectedUsers;
    
    public UserDAOTest() {
        
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
        
        expectedUsers = new ArrayList<User>();
        User user = new User("profe", "profe", profesor);
        expectedUsers.add(user);
    }
    
    @After
    public void tearDown() {
        UserDAO instance = new UserDAO();
        User entity = new User("john.doe", "john", levels.get(0));
        instance.delete(entity);
    }

    
    /**
     * Test of insert method, of class UserDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        User entity = new User("john.doe", "john", levels.get(0));
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = instance.insert(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class UserDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        User entity = new User("carlett.doe", "carlett", levels.get(0));
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = false;
        if (instance.insert(entity))
            result = instance.delete(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class UserDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User entity = expectedUsers.get(0);
        User user = new User(entity.getUsername(), "NewPassword", entity.getLevel());
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = instance.update(user);
        assertEquals(expResult, result);
        instance.update(entity);
    }

    /**
     * Test of selectAll method, of class UserDAO.
     */
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        UserDAO instance = new UserDAO();
        List<User> result = instance.selectAll();
        System.out.println(result.get(0).toString());
        assertEquals(expectedUsers, result);
    }

    /**
     * Test of selectById method, of class UserDAO.
     */
    @Test
    public void testSelectById() {
        System.out.println("selectById");
        String id = "profe";
        UserDAO instance = new UserDAO();
        User expResult = expectedUsers.get(0);
        User result = instance.selectById(id);
        assertEquals(expResult, result);
    }
    
}
