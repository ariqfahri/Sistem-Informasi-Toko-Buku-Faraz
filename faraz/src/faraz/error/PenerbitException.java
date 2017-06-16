/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.error;

/**
 *
 * @author FAM
 */
public class PenerbitException extends Exception {

    /**
     * Creates a new instance of
     * <code>PenerbitException</code> without detail message.
     */
    public PenerbitException() {
    }

    /**
     * Constructs an instance of
     * <code>PenerbitException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public PenerbitException(String msg) {
        super(msg);
    }
}
