/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.error;

/**
 *
 * @author FAM
 */
public class BukuException extends Exception {

    /**
     * Creates a new instance of
     * <code>BukuException</code> without detail message.
     */
    public BukuException() {
    }

    /**
     * Constructs an instance of
     * <code>BukuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public BukuException(String msg) {
        super(msg);
    }
}
