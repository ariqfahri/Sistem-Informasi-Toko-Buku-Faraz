/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service.impl;

import faraz.entity.Member;
import faraz.error.MemberException;
import faraz.service.MemberDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FAM
 */
public class MemberDaoImpl implements MemberDao{
    private Connection connection;
    
    private final String insertMember = "INSERT INTO member"
            + "(id_member, tanggal_member, nama, alamat, telepon, email)"
            + "VALUES (?,?,?,?,?,?)";
    
    private final String updateMember = "UPDATE member SET tanggal_member=?, nama=?, alamat=?, telepon=?, email=? WHERE id_member=?";
    
    private final String deleteMember = "DELETE FROM member WHERE id_member=?";
    
    private final String getById = "SELECT * FROM member WHERE id_member=?";
    
    private final String getByEmail = "SELECT * FROM member WHERE email=?";
    
    private final String selectAll = "SELECT * FROM member";
    
    private final String selectCount = "SELECT COUNT(*) FROM member WHERE id_member = ?";

    public MemberDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insertMember(Member member) throws MemberException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertMember);
            statement.setString(1, member.getId_member());
            statement.setDate(2, new Date(member.getTanggal_member().getTime()));
            statement.setString(3, member.getNama());
            statement.setString(4, member.getAlamat());
            statement.setString(5, member.getTelepon());
            statement.setString(6, member.getEmail());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new MemberException(exception.getMessage());
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
    public void updateMember(Member member) throws MemberException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateMember);
            statement.setDate(1, new Date(member.getTanggal_member().getTime()));
            statement.setString(2, member.getNama());
            statement.setString(3, member.getAlamat());
            statement.setString(4, member.getTelepon());
            statement.setString(5, member.getEmail());
            statement.setString(6, member.getId_member());
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new MemberException(exception.getMessage());
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
    public void deleteMember(String id_member) throws MemberException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteMember);
            statement.setString(1, id_member);
            statement.executeUpdate();
            
            connection.commit();
        } catch(SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new MemberException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public Member getMember(String id_member) throws MemberException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, id_member);
            
            ResultSet result = statement.executeQuery();
            Member member = null;
            if (result.next()) {
                member = new Member();
                member.setTanggal_member(result.getDate("tanggal_member"));
                member.setNama(result.getString("nama"));
                member.setAlamat(result.getString("alamat"));
                member.setTelepon(result.getString("telepon"));
                member.setEmail(result.getString("email"));
            } else {
                throw new MemberException("Member dengan id "+id_member+" tidak ditemukan");
            }
            connection.commit();
            return member;
        } catch(SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new MemberException(exception.getMessage());
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
    public Member getMemberByEmail(String email) throws MemberException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByEmail);
            statement.setString(1, email);
            
            ResultSet result = statement.executeQuery();
            Member member = null;
            if (result.next()) {
                member = new Member();
                member.setId_member(result.getString("id_member"));
                member.setTanggal_member(result.getDate("tanggal_member"));
                member.setNama(result.getString("nama"));
                member.setAlamat(result.getString("alamat"));
                member.setTelepon(result.getString("telepon"));
            } else {
                throw new MemberException("Member dengan id "+email+" tidak ditemukan");
            }
            connection.commit();
            return member;
        } catch(SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new MemberException(exception.getMessage());
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
    public List<Member> selectAllMember() throws MemberException {
        Statement statement = null;
        List<Member> list = new ArrayList<Member>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            
            while(result.next()){
                Member member = new Member();
                member.setId_member(result.getString("id_member"));
                member.setTanggal_member(result.getDate("tanggal_member"));
                member.setNama(result.getString("nama"));
                member.setAlamat(result.getString("alamat"));
                member.setTelepon(result.getString("telepon"));
                member.setEmail(result.getString("email"));
            
                list.add(member);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            throw new MemberException(exception.getMessage());
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
    public int selectCount(Member member) throws MemberException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectCount);
            statement.setString(1, member.getId_member());
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
            throw new MemberException(exception.getMessage());
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
    
}
