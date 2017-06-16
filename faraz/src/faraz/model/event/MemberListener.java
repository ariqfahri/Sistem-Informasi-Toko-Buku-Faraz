/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model.event;

import faraz.entity.Member;
import faraz.model.MemberModel;

/**
 *
 * @author FAM
 */
public interface MemberListener {
    
    public void onChange(MemberModel model);
    
    public void onInsert(Member member);
    
    public void onUpdate(Member member);
    
    public void onDelete();
}
