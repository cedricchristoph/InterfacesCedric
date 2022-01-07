/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.cc.gestionestudiantes.model.utils;

/**
 * Authorization Section
 * Esta clase se utiliza para determinar las distintas secciones a las que permitir o restringir el acceso
 * mediante Authorizations
 * @author cedric
 */
public enum AuthorizedSection {
    
    DASHBOARD(0),
    NUTRICION(1),
    BUSCAR_RECETAS(2),
    ESTADISTICAS(3),
    GESTION_USUARIOS(4),
    GESTION_NOTAS(5),
    MODIFICAR_RECETAS(6);
    
    Integer identifier;
    AuthorizedSection(Integer identifier) {
        this.identifier = identifier;
    }
    
    public Integer getIdentifier() {
        return identifier;
    }
    
    public static AuthorizedSection toAuthorizedSection(Integer id) {
        for (AuthorizedSection s : AuthorizedSection.values())
            if (s.getIdentifier() == id)
                return s;
        return null;
    }
}
