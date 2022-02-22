/*
Clase Excepcion cuando no se encuentra la cancion
 */
package exceptions;

/**
 *
 * @author MatiasVeraLima
 */
public class SongNotFoundException extends RuntimeException { 

    public SongNotFoundException() {
    }

    public SongNotFoundException(String message) {
        super(message);
    }
    
}
