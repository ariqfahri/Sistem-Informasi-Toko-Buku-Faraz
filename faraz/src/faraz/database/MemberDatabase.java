/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import faraz.service.MemberDao;
import faraz.service.impl.MemberDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author FAM
 */
public class MemberDatabase {
    
    private static Connection connection;
    private static MemberDao memberDao;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/farazbookstore");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
    public static MemberDao getMemberDao() throws SQLException {
        if (memberDao == null) {
            memberDao = new MemberDaoImpl(getConnection());
        }
        return memberDao;
    }
}
