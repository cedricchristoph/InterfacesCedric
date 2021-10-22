/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Cedric Christoph
 */
public class Game {
    
    /**
     * This variable contains the fields (bombs and empty)
     */
    private final Map map;
    
    /**
     * Standard constructor.
     */
    public Game() {
        map = new Map(8, 8, Map.DIFFICULTY_EASY);
    }
    
    /**
     * Constructor for Game Class
     * @param difficulty Dificulty of the game
     * @param map Map object
     */
    public Game(int difficulty, Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }    
}
