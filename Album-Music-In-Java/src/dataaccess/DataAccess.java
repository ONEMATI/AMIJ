/*
 Interfaz Acceso a al Informacion de la Biblioteca y Lista de Reproduccion 
 */
package dataaccess;

/**
 *
 * @author MatiasVeraLima
 */
public interface DataAccess <T> {
    void insert (T objet);
    void list ();
    void update (T objet);
    void delete (Long id);
    
    T getById (Long id);
    
}
