/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.error;

/**
 *
 * @author FAM
 */
public class AdminException extends Exception {

    /**
     * Creates a new instance of
     * <code>AdminException</code> without detail message.
     */
    public AdminException() {
    }

    /**
     * Constructs an instance of
     * <code>AdminException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public AdminException(String msg) {
        super(msg);
    }
}
