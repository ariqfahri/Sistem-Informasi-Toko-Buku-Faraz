/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model.event;

import faraz.entity.Penerbit;
import faraz.model.PenerbitModel;

/**
 *
 * @author FAM
 */
public interface PenerbitListener {
    
    public void onChange(PenerbitModel model);
    
    public void onInsert(Penerbit penerbit);
    
    public void onUpdate(Penerbit penerbit);
    
    public void onDelete();
}
