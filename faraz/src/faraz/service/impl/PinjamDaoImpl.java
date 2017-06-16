/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service.impl;

import faraz.entity.Pinjam;
import faraz.error.PinjamException;
import faraz.service.PinjamDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FAM
 */
public class PinjamDaoImpl implements PinjamDao{
    
    private Connection connection;
    
    private final String insertPinjam = "INSERT INTO pinjam"
            + "(id_member, id_buku, tanggal_pinjam, tanggal_kembali, harga_pinjam, denda)"
            + "VALUES (?,?,?,?,?,?)";
    
    private final String updatePinjam = "UPDATE pinjam SET id_member=?, id_buku=?, tanggal_dikembalikan=?, denda=? WHERE id_pinjam=?";
    
    private final String updatePengembalianKasir = "UPDATE pinjam SET tanggal_dikembalikan=?, denda=? WHERE id_pinjam=?";
    
    private final String deletePinjam = "DELETE FROM pinjam WHERE id_pinjam=?";
    
    private final String getById_member = "SELECT * FROM pinjam WHERE id_member=? AND tanggal_dikembalikan IS NULL";
    
    private final String lastLending = "SELECT id_member, id_buku FROM pinjam ORDER BY tanggal_pinjam DESC limit 7";
    
    private final String chartPinjam = "SELECT date(tanggal_pinjam) AS tanggal_pinjam, COUNT(id_pinjam) AS transaksi, SUM(harga_pinjam) AS total, SUM(denda) AS denda FROM pinjam GROUP BY date(tanggal_pinjam) LIMIT 30";
    
    private final String selectAll = "SELECT * FROM pinjam";
    
    public PinjamDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertPinjam(Pinjam pinjam) throws PinjamException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPinjam);
            statement.setString(1, pinjam.getId_member());
            statement.setString(2, pinjam.getId_buku());
            statement.setDate(3, new Date(pinjam.getTanggal_pinjam().getTime()));
            statement.setDate(4, new Date(pinjam.getTanggal_kembali().getTime()));
            statement.setInt(5, pinjam.getHarga_pinjam());
            statement.setInt(6, pinjam.getDenda());
            
            statement.executeUpdate();
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PinjamException(exception.getMessage());
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
    public void updatePinjam(Pinjam pinjam) throws PinjamException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePinjam);
            statement.setString(1, pinjam.getId_member());
            statement.setString(2, pinjam.getId_buku());
            statement.setDate(3, new Date(pinjam.getTanggal_dikembalikan().getTime()));
            statement.setInt(4, pinjam.getDenda());
            statement.setInt(5, pinjam.getId_pinjam());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PinjamException(exception.getMessage());
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
    public void updatePengembalianKasir(Pinjam pinjam) throws PinjamException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePengembalianKasir);
            statement.setDate(1, new Date(pinjam.getTanggal_dikembalikan().getTime()));
            statement.setInt(2, pinjam.getDenda());
            statement.setInt(3, pinjam.getId_pinjam());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PinjamException(exception.getMessage());
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
    public void deletePinjam(int id_pinjam) throws PinjamException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePinjam);
            statement.setInt(1, id_pinjam);
            statement.executeUpdate();
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PinjamException(exception.getMessage());
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
    public List<Pinjam> getPinjam(String id_member) throws PinjamException {
        PreparedStatement statement = null;
        List<Pinjam> list = new ArrayList<Pinjam>();
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById_member);
            statement.setString(1, id_member);
            
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Pinjam pinjam = new Pinjam();
                pinjam.setId_pinjam(result.getInt("id_pinjam"));
                pinjam.setId_member(result.getString("id_member"));
                pinjam.setId_buku(result.getString("id_buku"));
                pinjam.setTanggal_pinjam(result.getDate("tanggal_pinjam"));
                pinjam.setTanggal_kembali(result.getDate("tanggal_kembali"));
                pinjam.setTanggal_dikembalikan(result.getDate("tanggal_dikembalikan"));
                pinjam.setHarga_pinjam(result.getInt("harga_pinjam"));
                pinjam.setDenda(result.getInt("denda"));
                list.add(pinjam);
            }
            connection.commit();
            return list;
        } catch(SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new PinjamException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Pinjam> top7LastLending() throws PinjamException {
        Statement statement = null;
        List<Pinjam> list = new ArrayList<Pinjam>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(lastLending);
            
            while(result.next()){
                Pinjam pinjam = new Pinjam();
                pinjam.setId_member(result.getString("id_member"));
                pinjam.setId_buku(result.getString("id_buku"));
                list.add(pinjam);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PinjamException(exception.getMessage());
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
    public List<Pinjam> chartPinjam() throws PinjamException {
        Statement statement = null;
        List<Pinjam> list = new ArrayList<Pinjam>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(chartPinjam);
            
            while(result.next()){
                Pinjam pinjam = new Pinjam();
                pinjam.setTanggal_pinjam(result.getDate("tanggal_pinjam"));
                pinjam.setId_pinjam(result.getInt("transaksi"));
                pinjam.setHarga_pinjam(result.getInt("total"));
                pinjam.setDenda(result.getInt("denda"));
                list.add(pinjam);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PinjamException(exception.getMessage());
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
    public List<Pinjam> selectAllPinjam() throws PinjamException {
        Statement statement = null;
        List<Pinjam> list = new ArrayList<Pinjam>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                Pinjam pinjam = new Pinjam();
                pinjam.setId_pinjam(result.getInt("id_pinjam"));
                pinjam.setId_member(result.getString("id_member"));
                pinjam.setId_buku(result.getString("id_buku"));
                pinjam.setTanggal_pinjam(result.getDate("tanggal_pinjam"));
                pinjam.setTanggal_kembali(result.getDate("tanggal_kembali"));
                pinjam.setTanggal_dikembalikan(result.getDate("tanggal_dikembalikan"));
                pinjam.setHarga_pinjam(result.getInt("harga_pinjam"));
                pinjam.setDenda(result.getInt("denda"));
                list.add(pinjam);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PinjamException(exception.getMessage());
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
