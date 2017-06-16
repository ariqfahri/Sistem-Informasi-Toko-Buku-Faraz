/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service.impl;

import faraz.entity.Penerbit;
import faraz.error.PenerbitException;
import faraz.service.PenerbitDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FAM
 */
public class PenerbitDaoImpl implements PenerbitDao{
    private Connection connection;
    
    private final String insertPenerbit = "INSERT INTO penerbit (id_penerbit, nama_penerbit) VALUES (?,?)";
    
    private final String updatePenerbit = "UPDATE penerbit SET nama_penerbit=? WHERE id_penerbit=?";
    
    private final String deletePenerbit = "DELETE FROM penerbit WHERE id_penerbit=?";
    
    private final String getById = "SELECT * FROM penerbit WHERE id_penerbit=?";
    
    private final String selectAll = "SELECT * FROM penerbit";
    
    public PenerbitDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPenerbit(Penerbit penerbit) throws PenerbitException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPenerbit);
            statement.setString(1, penerbit.getId_penerbit());
            statement.setString(2, penerbit.getNama_penerbit());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenerbitException(exception.getMessage());
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
    public void updatePenerbit(Penerbit penerbit) throws PenerbitException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePenerbit);
            statement.setString(1, penerbit.getNama_penerbit());
            statement.setString(2, penerbit.getId_penerbit());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenerbitException(exception.getMessage());
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
    public void deletePenerbit(String id_penerbit) throws PenerbitException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePenerbit);
            statement.setString(1, id_penerbit);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenerbitException(exception.getMessage());
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
    public Penerbit getPenerbit(String id_penerbit) throws PenerbitException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, id_penerbit);
            
            ResultSet result = statement.executeQuery();
            Penerbit penerbit = null;
            if (result.next()) {
                penerbit = new Penerbit();
                penerbit.setNama_penerbit(result.getString("nama_penerbit"));
            } else {
                throw new PenerbitException("Penerbit dengan id "+id_penerbit+" tidak ditemukan");
            }
            connection.commit();
            return penerbit;
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenerbitException(exception.getMessage());
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
    public List<Penerbit> selectAllPenerbit() throws PenerbitException {
        Statement statement = null;
        List<Penerbit> list = new ArrayList<Penerbit>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                Penerbit penerbit = new Penerbit();
                penerbit.setId_penerbit(result.getString("id_penerbit"));
                penerbit.setNama_penerbit(result.getString("nama_penerbit"));
            
                list.add(penerbit);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenerbitException(exception.getMessage());
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
