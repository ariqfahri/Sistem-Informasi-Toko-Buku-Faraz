/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import faraz.service.BukuDao;
import faraz.service.impl.BukuDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author FAM
 */
public class BukuDatabase {
    
    private static Connection connection;
    private static BukuDao bukuDao;
    
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
    
    public static BukuDao getBukuDao() throws SQLException {
        if (bukuDao == null) {
            bukuDao = new BukuDaoImpl(getConnection());
        }
        return bukuDao;
    }
}
