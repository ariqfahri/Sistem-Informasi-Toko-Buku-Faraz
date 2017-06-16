/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import faraz.service.PinjamDao;
import faraz.service.impl.PinjamDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author FAM
 */
public class PinjamDatabase {

    private static Connection connection;
    private static PinjamDao pinjamDao;

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
    
    public static PinjamDao getPinjamDao() throws SQLException {
        if (pinjamDao == null) {
            pinjamDao = new PinjamDaoImpl(getConnection());
        }
        return pinjamDao;
    }
}
