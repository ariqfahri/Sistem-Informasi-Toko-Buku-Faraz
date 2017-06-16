/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model.event;

import faraz.entity.Buku;
import faraz.model.BukuModel;

/**
 *
 * @author FAM
 */
public interface BukuListener {

    public void onChange(BukuModel model);

    public void onInsert(Buku buku);

    public void onUpdate(Buku buku);

    public void onDelete();
}
