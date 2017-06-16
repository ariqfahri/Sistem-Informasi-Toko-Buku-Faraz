/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model.event;

import faraz.entity.JualBeli;
import faraz.model.JualBeliModel;

/**
 *
 * @author FAM
 */
public interface JualBeliListener {
    
    public void onChange(JualBeliModel model);

    public void onInsert(JualBeli jualbeli);

    public void onUpdate(JualBeli jualbeli);

    public void onDelete();
}
