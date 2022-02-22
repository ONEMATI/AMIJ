/*
Clase Excepcion cuando no se encuentra la playlist
 */
package exceptions;

/**
 *
 * @author MatiasVeraLima
 */
public class PlayListNotFoundException extends RuntimeException {

    public PlayListNotFoundException() {
    }

    public PlayListNotFoundException(String message) {
        super(message);
    }
    
}
