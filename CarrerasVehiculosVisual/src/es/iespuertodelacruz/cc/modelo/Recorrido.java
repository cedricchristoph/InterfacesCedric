/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.modelo;

/**
 *
 * @author Cedric Christoph
 */
public class Recorrido {
    
    private int distanciaTotal;
    private Curva[] curvas;
    private boolean[] ruta;
    
    /**
     * Constructor de la clase Recorrido
     * @param distancia
     * @param curvas
     */
    public Recorrido(Integer distancia, Integer curvas) {
        distanciaTotal = distancia;
        this.curvas = new Curva[curvas];
        for (int i = 0; i < this.curvas.length; i++) {
            this.curvas[i] = getRandomCurva();
        }
        generarRuta();
    }
    
    /**
     * Funcion que devulve una curva con cierta dificultad (random)
     * @return 
     */
    private Curva getRandomCurva() {
        Integer rnd = (int) (Math.random() * 3 - 1) + 1;
        switch (rnd) {
            case 1:
                return new Curva(Curva.DIFICULTAD_BAJA);
            case 2:
                return new Curva(Curva.DIFICULTAD_MEDIA);
            case 3:
                return new Curva(Curva.DIFICULTAD_ALTA);
        }
        return null;
    }
    
    /**
     * Metodo para generar una ruta a recorrer que indica cada 100m si hay o no una curva
     */
    private void generarRuta() {
        ruta = new boolean[distanciaTotal/100];
        while (countCurvasEnRuta() < curvas.length) {
            for (int i = 2; i < ruta.length; i++) {
                if (ruta[i] == false)
                    ruta[i] = getRandomBoolean();
            }
        }
    }
    
    /**
     * Funcion que devuelve la cantidad total de curvas en la ruta
     * @return 
     */
    private Integer countCurvasEnRuta() {
        Integer counter = 0;
        for (int i = 1; i < ruta.length; i++) {
            if (ruta[i] == true)
                counter += 1;
        }
        return counter;
    }
    
    public Curva getCurva(Integer numero) {
        try {
            return curvas[numero];
        } catch (Exception e) {
            return new Curva(Curva.DIFICULTAD_BAJA);
        }
    }
    
    /**
     * Funcion que devuelve un booleano
     * @return True en 15% de los casos. False en 80% de los casos;
     */
    private boolean getRandomBoolean() {
        return Math.random() < 0.15;
    }

    public int getDistanciaTotal() {
        return distanciaTotal;
    }

    public Curva[] getCurvas() {
        return curvas;
    }

    public boolean[] getRuta() {
        return ruta;
    }

    public void setDistanciaTotal(int distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public void setCurvas(Curva[] curvas) {
        this.curvas = curvas;
    }

    public void setRuta(boolean[] ruta) {
        this.ruta = ruta;
    }
    
    
    
}
