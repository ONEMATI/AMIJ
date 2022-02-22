/*

 */
package exceptions;

/**
 *
 * @author matia
 */
public class PlayListNotFoundException extends RuntimeException {

    public PlayListNotFoundException() {
    }

    public PlayListNotFoundException(String message) {
        super(message);
    }
    
}
