/*

 */
package exceptions;

/**
 *
 * @author TammyYMati
 */
public class SongNotFoundException extends RuntimeException { 

    public SongNotFoundException() {
    }

    public SongNotFoundException(String message) {
        super(message);
    }
    
}
