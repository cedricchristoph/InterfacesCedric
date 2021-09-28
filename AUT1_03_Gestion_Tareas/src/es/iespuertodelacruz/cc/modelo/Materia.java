
package es.iespuertodelacruz.cc.modelo;

/**
 *
 * @author Cedric Christoph
 */
public enum Materia {
    
    DAD("Desarrollo de interfaces"), EMR("Empresa e iniciativa emprendedora"),
    PGV("Programacion de servicios y procesos"), AED("Acceso a datos"),
    PGL("Programacion multimedia"), SSG("Sistemas de gestion empresarial");
    
    private String nombre;
    
    Materia(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Funcion para devolver el ENUM Materia que se esta buscando
     * @param nombre Nombre escrito de la materia
     * @return Objeto Materia encontrada o null si no existe
     */
    public static Materia getMateria(String nombre) {
        for (Materia materia : getMaterias()) {
            if (materia.getNombre().equals(nombre))
                return materia;
        }
        return null;
    }
    
    public static Materia[] getMaterias() {
        Materia[] materias = {DAD,EMR,PGV,AED,PGL,SSG};
        return materias;
    }
}