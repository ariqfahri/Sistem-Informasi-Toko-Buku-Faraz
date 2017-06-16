/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service;

import faraz.entity.Member;
import faraz.error.MemberException;
import java.util.List;

/**
 *
 * @author FAM
 */
public interface MemberDao {
    
    public void insertMember(Member member) throws MemberException;
    
    public void updateMember(Member member) throws MemberException;
    
    public void deleteMember(String id_member) throws MemberException;
    
    public Member getMember(String id_member) throws MemberException;
    
    public Member getMemberByEmail(String email) throws MemberException;
    
    public int selectCount(Member member) throws MemberException;
    
    public List<Member> selectAllMember() throws MemberException;
}
