/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service;

import faraz.entity.JualBeli;
import faraz.error.JualBeliException;
import java.util.List;

/**
 *
 * @author FAM
 */
public interface JualBeliDao {
    
    public void insertJualBeli(JualBeli jualbeli) throws JualBeliException;
    
    public void updateJualBeli(JualBeli jualbeli) throws JualBeliException;
    
    public void deleteJualBeli(int id_jualbeli) throws JualBeliException;
    
    public JualBeli getJualBeli(int id_jualbeli) throws JualBeliException;
    
    public List<JualBeli> chartJualBeli() throws JualBeliException;
    
    public List<JualBeli> selectAllJualBeli() throws JualBeliException;
}
