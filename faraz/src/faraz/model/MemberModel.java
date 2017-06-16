/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.database.MemberDatabase;
import faraz.entity.Member;
import faraz.error.MemberException;
import faraz.model.event.MemberListener;
import faraz.service.MemberDao;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author FAM
 */
public class MemberModel {
    
    private String id_member, nama, alamat, telepon, email, foto;
    private Date tanggal_member;
    
    private MemberListener listener;

    public MemberListener getListener() {
        return listener;
    }

    public void setListener(MemberListener listener) {
        this.listener = listener;
    }
            
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
        fireOnChange();
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public Date getTanggal_member() {
        return tanggal_member;
    }

    public void setTanggal_member(Date tanggal_member) {
        this.tanggal_member = tanggal_member;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }
    
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Member member) {
        if (listener != null) {
            listener.onInsert(member);
        }
    }
    
    protected void fireOnUpdate(Member member) {
        if (listener != null) {
            listener.onUpdate(member);
        }
    }
    
    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void resetMember() {
        setId_member("");
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
        setTanggal_member(new Date());
    }
    
    public void insertMember() throws SQLException, MemberException {
        MemberDao dao = MemberDatabase.getMemberDao();
        
        Member member = new Member();
        member.setId_member(id_member);
        member.setNama(nama);
        member.setAlamat(alamat);
        member.setTelepon(telepon);
        member.setEmail(email);
        member.setTanggal_member(tanggal_member);
        
        dao.insertMember(member);
        
        fireOnInsert(member);
    }
    
    public void updateMember() throws SQLException, MemberException {
        MemberDao dao = MemberDatabase.getMemberDao();
        
        Member member = new Member();
        member.setId_member(id_member);
        member.setNama(nama);
        member.setAlamat(alamat);
        member.setTelepon(telepon);
        member.setEmail(email);
        member.setTanggal_member(tanggal_member);
        
        dao.updateMember(member);
        
        fireOnUpdate(member);
    }
    
    public void deleteMember() throws SQLException, MemberException {
        MemberDao dao = MemberDatabase.getMemberDao();
        
        dao.deleteMember(id_member);
        
        fireOnDelete();
    }
}
