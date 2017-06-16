/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service;

import faraz.entity.Admin;
import faraz.error.AdminException;

/**
 *
 * @author FAM
 */
public interface AdminDao {
    
    public int selectCount(Admin admin) throws AdminException;
    
    public void update(Admin admin) throws AdminException;
    
    public Admin getAdmin(String id_admin) throws AdminException;
    
}
