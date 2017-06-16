/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service.impl;

import faraz.entity.Admin;
import faraz.error.AdminException;
import faraz.service.AdminDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FAM
 */
public class AdminDaoImpl implements AdminDao{
    
    private Connection connection;
    
    private final String selectCount = "SELECT COUNT(*) FROM admin WHERE id_admin=? AND password=?";
    
    private final String updateAdmin = "UPDATE admin SET password=? WHERE id_admin=?";
    
    private final String getById = "SELECT * FROM admin WHERE id_admin=?";

    public AdminDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int selectCount(Admin admin) throws AdminException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectCount);
            statement.setString(1, admin.getId_admin());
            statement.setString(2, admin.getPassword());
            resultSet = statement.executeQuery();
            connection.commit();
            while (resultSet.next()) {
                rowCount = resultSet.getInt(1);
            }
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AdminException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        return rowCount;
    }

    @Override
    public void update(Admin admin) throws AdminException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateAdmin);
            statement.setString(1, admin.getPassword());
            statement.setString(2, admin.getId_admin());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AdminException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public Admin getAdmin(String id_admin) throws AdminException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, id_admin);
            
            ResultSet result = statement.executeQuery();
            Admin admin = null;
            if (result.next()) {
                admin = new Admin();
                admin.setId_admin(result.getString("id_admin"));
                admin.setPassword(result.getString("password"));
            } else {
                throw new AdminException("Data Admin dengan id "+id_admin+" tidak ditemukan");
            }
            connection.commit();
            return admin;
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new AdminException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
    
}
