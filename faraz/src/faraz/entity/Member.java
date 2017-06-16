/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.entity;

import java.util.Date;

/**
 *
 * @author FAM
 */
public class Member {
    private String id_member, nama, alamat, telepon, email, foto;
    private Date tanggal_member;

    public Member() {
    }

    public Member(String id_member, String nama, String alamat, String telepon, String email, String foto, Date tanggal_member) {
        this.id_member = id_member;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
        this.foto = foto;
        this.tanggal_member = tanggal_member;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getTanggal_member() {
        return tanggal_member;
    }

    public void setTanggal_member(Date tanggal_member) {
        this.tanggal_member = tanggal_member;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if ((this.id_member == null) ? (other.id_member != null) : !this.id_member.equals(other.id_member)) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if ((this.alamat == null) ? (other.alamat != null) : !this.alamat.equals(other.alamat)) {
            return false;
        }
        if ((this.telepon == null) ? (other.telepon != null) : !this.telepon.equals(other.telepon)) {
            return false;
        }
        if ((this.foto == null) ? (other.foto != null) : !this.foto.equals(other.foto)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.id_member != null ? this.id_member.hashCode() : 0);
        hash = 61 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 61 * hash + (this.alamat != null ? this.alamat.hashCode() : 0);
        hash = 61 * hash + (this.telepon != null ? this.telepon.hashCode() : 0);
        hash = 61 * hash + (this.foto != null ? this.foto.hashCode() : 0);
        return hash;
    }
    
    
}
