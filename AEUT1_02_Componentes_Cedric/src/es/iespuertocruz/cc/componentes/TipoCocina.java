/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertocruz.cc.componentes;

/**
 *
 * @author dama
 */
public enum TipoCocina {
    
    BUFE("Bufé"), 
    CARTA("Carta"), 
    PEDIR_CITA("Pedir cita con el chef"), 
    NO_PRECISA("No precisa");
    
    private final String nombre;
    
    private TipoCocina(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    /**
     * Funcion para devolver el tipo de concina dependiendo del input STRING
     * @param input
     * @return 
     */
    public static TipoCocina getTipo(String input) {
        switch (input) {
            case "Bufé":
                return BUFE;
            case "Carta":
                return CARTA;
            case "Pedir cita con el chef":
                return PEDIR_CITA;
            case "No precisa":
                return NO_PRECISA;
        }
        return null;
    }
    
}
