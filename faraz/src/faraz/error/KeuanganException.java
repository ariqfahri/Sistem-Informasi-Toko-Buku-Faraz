/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.error;

/**
 *
 * @author FAM
 */
public class KeuanganException extends Exception {

    /**
     * Creates a new instance of
     * <code>KeuanganException</code> without detail message.
     */
    public KeuanganException() {
    }

    /**
     * Constructs an instance of
     * <code>KeuanganException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public KeuanganException(String msg) {
        super(msg);
    }
}
