/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service.impl;

import faraz.entity.JualBeli;
import faraz.error.JualBeliException;
import faraz.service.JualBeliDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FAM
 */
public class JualBeliDaoImpl implements JualBeliDao{
    
    private final String insertJualBeli = "INSERT INTO jualbeli"
            + "(tanggal_jualbeli, id_member, id_buku, harga_jual, kuantitas, total)"
            + "VALUES (?,?,?,?,?,?)";
    
    private final String updateJualBeli = "UPDATE jualbeli SET id_member=?, id_buku=? WHERE id_jualbeli=?";
    
    private final String deleteJualBeli = "DELETE FROM jualbeli WHERE id_jualbeli=?";
    
    private final String getById = "SELECT * FROM jualbeli WHERE id_jualbeli=?";
    
    private final String chartJualBeli = "SELECT date(tanggal_jualbeli) AS tanggal_jualbeli, COUNT(id_jualbeli) AS transaksi, SUM(total) AS total FROM jualbeli GROUP BY date(tanggal_jualbeli) LIMIT 30";
    
    private final String selectAll = "SELECT * FROM jualbeli";
    
    private Connection connection;

    public JualBeliDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertJualBeli(JualBeli jualbeli) throws JualBeliException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertJualBeli);
            statement.setDate(1, new Date(jualbeli.getTanggal_jualbeli().getTime()));
            statement.setString(2, jualbeli.getId_member());
            statement.setString(3, jualbeli.getId_buku());
            statement.setInt(4, jualbeli.getHarga_jual());
            statement.setInt(5, jualbeli.getKuantitas());
            statement.setInt(6, jualbeli.getTotal());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JualBeliException(exception.getMessage());
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
    public void updateJualBeli(JualBeli jualbeli) throws JualBeliException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateJualBeli);
            statement.setString(1, jualbeli.getId_member());
            statement.setString(2, jualbeli.getId_buku());
            statement.setInt(3, jualbeli.getId_jualbeli());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JualBeliException(exception.getMessage());
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
    public void deleteJualBeli(int id_jualbeli) throws JualBeliException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteJualBeli);
            statement.setInt(1, id_jualbeli);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JualBeliException(exception.getMessage());
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
    public JualBeli getJualBeli(int id_jualbeli) throws JualBeliException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id_jualbeli);
            
            ResultSet result = statement.executeQuery();
            JualBeli jualbeli = null;
            if (result.next()) {
                jualbeli = new JualBeli();
                jualbeli.setTanggal_jualbeli(result.getDate("tanggal_jualbeli"));
                jualbeli.setId_member(result.getString("id_member"));
                jualbeli.setId_buku(result.getString("id_buku"));
                jualbeli.setHarga_jual(result.getInt("harga_jual"));
                jualbeli.setKuantitas(result.getInt("kuantitas"));
                jualbeli.setTotal(result.getInt("total"));
            } else {
                throw new JualBeliException("Data Penjualan dengan id "+id_jualbeli+" tidak ditemukan");
            }
            connection.commit();
            return jualbeli;
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JualBeliException(exception.getMessage());
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
    public List<JualBeli> chartJualBeli() throws JualBeliException {
        Statement statement = null;
        List<JualBeli> list = new ArrayList<JualBeli>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(chartJualBeli);
            
            while(result.next()){
                JualBeli jualbeli = new JualBeli();
                jualbeli.setId_jualbeli(result.getInt("transaksi"));
                jualbeli.setTanggal_jualbeli(result.getDate("tanggal_jualbeli"));
                jualbeli.setTotal(result.getInt("total"));
                list.add(jualbeli);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JualBeliException(exception.getMessage());
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
    public List<JualBeli> selectAllJualBeli() throws JualBeliException {
        Statement statement = null;
        List<JualBeli> list = new ArrayList<JualBeli>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                JualBeli jualbeli = new JualBeli();
                jualbeli.setId_jualbeli(result.getInt("id_jualbeli"));
                jualbeli.setTanggal_jualbeli(result.getDate("tanggal_jualbeli"));
                jualbeli.setId_member(result.getString("id_member"));
                jualbeli.setId_buku(result.getString("id_buku"));
                jualbeli.setHarga_jual(result.getInt("harga_jual"));
                jualbeli.setKuantitas(result.getInt("kuantitas"));
                jualbeli.setTotal(result.getInt("total"));
                list.add(jualbeli);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JualBeliException(exception.getMessage());
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
