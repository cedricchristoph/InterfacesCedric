/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Dimension;

/**
 *
 * @author Cedric Christoph
 */
public class Map {
    
    /**
     * Difficulties
     */
    public static final int DIFFICULTY_EASY = 20;
    public static final int DIFFICULTY_MEDIUM = 10;
    public static final int DIFFICULTY_HARD = 8;
    public static final int DIFFICULTY_VERY_HARD = 6;
    
    /**
     * This variable determines the probability of bombs
     */
    private final int difficulty;
    
    /**
     * This variable contains the actual map
     */
    private final Field[][] map;
    
    /**
     * Constructor
     * @param width
     * @param height
     * @param difficulty 
     */
    public Map(int width, int height, int difficulty) { 
        this.difficulty = difficulty;
        map = new Field[width][height];
        init();
    }
    
    /**
     * Constructor
     * @param dimensiones
     * @param difficulty 
     */
    public Map(Dimension dimensiones, int difficulty) {
        this.difficulty = difficulty;
        map = new Field[dimensiones.width][dimensiones.height];
        init();
    }
    
    /**
     * Method that initializes the map
     */
    private void init() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = getRandomField();
            }
        }
    }
    
    /**
     * Function that returns a bomb field or empty field according to the difficulty
     * @return Field object
     */
    private Field getRandomField() {
        int rnd = (int) (Math.random() * (difficulty));
        if (rnd == 1)
            return new BombField();
        return new EmptyField();
    }

    /**
     * Function that return the amount of bombs surrounding a specific field
     * @param x Position x of the field to check
     * @param y Position y of the field to check
     * @return Returns integer amount of bombs
     */
    public int getBombCount(int x, int y) {
        int[][] positionsToCheck = new int[8][2];
        if (!((x <= map.length && x >= 0) && (y <= map[0].length && y >= 0))) {
            Field toCheck = map[x][y];
            int bombCount = 0;
            
        }
        return 0;
    }
    
    private int checkBombs(int[][] positions) {
        int count = 0;
        for (int[] pair : positions) {
            int x = pair[0];
            int y = pair[1];
            if (map[x][y].isBomb())
                count++;
        }
        return count;
    }
    
    // Getters & Setters
    
    public int getDifficulty() {
        return difficulty;
    }

    public Field[][] getMap() {
        return map;
    }
}
