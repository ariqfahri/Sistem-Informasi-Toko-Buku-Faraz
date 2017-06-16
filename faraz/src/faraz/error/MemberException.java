/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.error;

/**
 *
 * @author FAM
 */
public class MemberException extends Exception {

    /**
     * Creates a new instance of
     * <code>MemberException</code> without detail message.
     */
    public MemberException() {
    }

    /**
     * Constructs an instance of
     * <code>MemberException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MemberException(String msg) {
        super(msg);
    }
}
