/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.entity;

/**
 *
 * @author FAM
 */
public class Admin {
    private String id_admin, password;

    public Admin() {
    }

    public Admin(String id_admin, String password) {
        this.id_admin = id_admin;
        this.password = password;
    }

    public String getId_admin() {
        return id_admin;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin other = (Admin) obj;
        if ((this.id_admin == null) ? (other.id_admin != null) : !this.id_admin.equals(other.id_admin)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.id_admin != null ? this.id_admin.hashCode() : 0);
        hash = 41 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }
    
    
}
