/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.error;

/**
 *
 * @author FAM
 */
public class PinjamException extends Exception {

    /**
     * Creates a new instance of
     * <code>PinjamException</code> without detail message.
     */
    public PinjamException() {
    }

    /**
     * Constructs an instance of
     * <code>PinjamException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public PinjamException(String msg) {
        super(msg);
    }
}
