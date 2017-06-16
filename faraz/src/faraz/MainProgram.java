/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz;

import faraz.error.BukuException;
import faraz.error.MemberException;
import faraz.view.KasirView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author FAM
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                KasirView kasir = null;
                try {
                    kasir = new KasirView();
                } catch (SQLException ex) {
                    Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BukuException ex) {
                    Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MemberException ex) {
                    Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
                }
                kasir.setVisible(true);
            }
        });
    }
}
