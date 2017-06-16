/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model.event;

import faraz.entity.Pinjam;
import faraz.model.PinjamModel;

/**
 *
 * @author FAM
 */
public interface PinjamListener {
    
    public void onChange(PinjamModel model);

    public void onInsert(Pinjam pinjam);

    public void onUpdate(Pinjam pinjam);

    public void onDelete();
}
