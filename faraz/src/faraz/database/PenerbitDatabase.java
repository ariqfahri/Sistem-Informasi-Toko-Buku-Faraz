/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import faraz.service.PenerbitDao;
import faraz.service.impl.PenerbitDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author FAM
 */
public class PenerbitDatabase {

    private static Connection connection;
    private static PenerbitDao penerbitDao;
    
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
    
    public static PenerbitDao getPenerbitDao() throws SQLException {
        if (penerbitDao == null) {
            penerbitDao = new PenerbitDaoImpl(getConnection());
        }
        return penerbitDao;
    }
}
