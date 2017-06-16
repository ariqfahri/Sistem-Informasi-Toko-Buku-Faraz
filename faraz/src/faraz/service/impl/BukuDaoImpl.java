/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service.impl;

import faraz.entity.Buku;
import faraz.error.BukuException;
import faraz.service.BukuDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FAM
 */
public class BukuDaoImpl implements BukuDao{
    
    private Connection connection;
    
    private final String insertBuku = "INSERT INTO buku"
            + "(id_buku, id_penerbit, tanggal_buku, judul_buku, pengarang, jumlah_buku, jumlah_tersedia, jumlah_dipinjam, counter, harga_pinjam, harga_jual, harga_baca)"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    
    private final String updateBuku = "UPDATE buku SET id_penerbit=?, judul_buku=?, pengarang=?, jumlah_buku=?, jumlah_tersedia=?, jumlah_dipinjam=?, harga_pinjam=?, harga_jual=?, harga_baca=? WHERE id_buku=?";
    
    private final String updatePinjamBukuKasir = "UPDATE buku SET jumlah_tersedia=jumlah_tersedia-1, jumlah_dipinjam=jumlah_dipinjam+1, counter=counter+1 WHERE id_buku=?";
    
    private final String updatePengembalianBukuKasir = "UPDATE buku SET jumlah_tersedia=jumlah_tersedia+1, jumlah_dipinjam=jumlah_dipinjam-1 WHERE id_buku=?";
    
    private final String updateJualBeliBukuKasir = "UPDATE buku SET jumlah_buku=jumlah_buku-?, jumlah_tersedia=jumlah_tersedia-? WHERE id_buku=?";
    
    private final String deleteBuku = "DELETE FROM buku WHERE id_buku=?";
    
    private final String top7Buku = "SELECT judul_buku, counter FROM buku ORDER BY counter DESC limit 7";
    
    private final String top7NewBuku = "SELECT judul_buku FROM buku ORDER BY tanggal_buku DESC limit 7";
    
    private final String getById = "SELECT * FROM buku WHERE id_buku=?";
    
    private final String selectAll = "SELECT * FROM buku";
    
    public BukuDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertBuku(Buku buku) throws BukuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertBuku);
            statement.setString(1, buku.getId_buku());
            statement.setString(2, buku.getId_penerbit());
            statement.setDate(3, new Date(buku.getTanggal_buku().getTime()));
            statement.setString(4, buku.getJudul_buku());
            statement.setString(5, buku.getPengarang());
            statement.setInt(6, buku.getJumlah_buku());
            statement.setInt(7, buku.getJumlah_tersedia());
            statement.setInt(8, buku.getJumlah_dipinjam());
            statement.setInt(9, buku.getCounter());
            statement.setInt(10, buku.getHarga_pinjam());
            statement.setInt(11, buku.getHarga_jual());
            statement.setInt(12, buku.getHarga_baca());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public void updateBuku(Buku buku) throws BukuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateBuku);
            statement.setString(1, buku.getId_penerbit());
            statement.setString(2, buku.getJudul_buku());
            statement.setString(3, buku.getPengarang());
            statement.setInt(4, buku.getJumlah_buku());
            statement.setInt(5, buku.getJumlah_tersedia());
            statement.setInt(6, buku.getJumlah_dipinjam());
            statement.setInt(7, buku.getHarga_pinjam());
            statement.setInt(8, buku.getHarga_jual());
            statement.setInt(9, buku.getHarga_baca());
            statement.setString(10, buku.getId_buku());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public void updatePinjamBukuKasir(String id_buku) throws BukuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePinjamBukuKasir);
            statement.setString(1, id_buku);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public void updatePengembalianBukuKasir(String id_buku) throws BukuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePengembalianBukuKasir);
            statement.setString(1, id_buku);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public void updateJualBeliBukuKasir(Buku buku) throws BukuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateJualBeliBukuKasir);
            statement.setInt(1, buku.getBantuan());
            statement.setInt(2, buku.getBantuan());
            statement.setString(3, buku.getId_buku());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public void deleteBuku(String id_buku) throws BukuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteBuku);
            statement.setString(1, id_buku);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public Buku getBuku(String id_buku) throws BukuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, id_buku);
            
            ResultSet result = statement.executeQuery();
            Buku buku = null;
            if (result.next()) {
                buku = new Buku();
                buku.setTanggal_buku(result.getDate("tanggal_buku"));
                buku.setJudul_buku(result.getString("judul_buku"));
                buku.setPengarang(result.getString("pengarang"));
                buku.setJumlah_buku(result.getInt("jumlah_buku"));
                buku.setJumlah_tersedia(result.getInt("jumlah_tersedia"));
                buku.setJumlah_dipinjam(result.getInt("jumlah_dipinjam"));
                buku.setCounter(result.getInt("counter"));
                buku.setHarga_pinjam(result.getInt("harga_pinjam"));
                buku.setHarga_jual(result.getInt("harga_jual"));
                buku.setHarga_baca(result.getInt("harga_baca"));
            } else {
                throw new BukuException("Buku dengan id "+id_buku+" tidak ditemukan");
            }
            connection.commit();
            return buku;
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public List<Buku> top7Buku() throws BukuException {
        Statement statement = null;
        List<Buku> list = new ArrayList<Buku>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(top7Buku);
            
            while(result.next()){
                Buku buku = new Buku();
                buku.setJudul_buku(result.getString("judul_buku"));
                buku.setCounter(result.getInt("counter"));
                list.add(buku);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public List<Buku> top7NewBuku() throws BukuException {
        Statement statement = null;
        List<Buku> list = new ArrayList<Buku>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(top7NewBuku);
            
            while(result.next()){
                Buku buku = new Buku();
                buku.setJudul_buku(result.getString("judul_buku"));
                list.add(buku);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
    public List<Buku> selectAllBuku() throws BukuException {
        Statement statement = null;
        List<Buku> list = new ArrayList<Buku>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                Buku buku = new Buku();
                buku.setId_buku(result.getString("id_buku"));
                buku.setId_penerbit(result.getString("id_penerbit"));
                buku.setTanggal_buku(result.getDate("tanggal_buku"));
                buku.setJudul_buku(result.getString("judul_buku"));
                buku.setPengarang(result.getString("pengarang"));
                buku.setJumlah_buku(result.getInt("jumlah_buku"));
                buku.setJumlah_tersedia(result.getInt("jumlah_tersedia"));
                buku.setJumlah_dipinjam(result.getInt("jumlah_dipinjam"));
                buku.setCounter(result.getInt("counter"));
                buku.setHarga_pinjam(result.getInt("harga_pinjam"));
                buku.setHarga_jual(result.getInt("harga_jual"));
                buku.setHarga_baca(result.getInt("harga_baca"));
                list.add(buku);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BukuException(exception.getMessage());
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
