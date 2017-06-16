/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import faraz.service.AdminDao;
import faraz.service.impl.AdminDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author FAM
 */
public class AdminDatabase {
    
    private static Connection connection;
    private static AdminDao adminDao;
    
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
    
    public static AdminDao getAdminDao() throws SQLException {
        if (adminDao == null) {
            adminDao = new AdminDaoImpl(getConnection());
        }
        return adminDao;
    }
}
