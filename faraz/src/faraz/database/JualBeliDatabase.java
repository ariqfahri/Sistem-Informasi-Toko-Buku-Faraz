/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import faraz.service.JualBeliDao;
import faraz.service.impl.JualBeliDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author FAM
 */
public class JualBeliDatabase {
    
    private static Connection connection;
    private static JualBeliDao jualbeliDao;
    
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
    
    public static JualBeliDao getJualBeliDao() throws SQLException {
        if (jualbeliDao == null) {
            jualbeliDao = new JualBeliDaoImpl(getConnection());
        }
        return jualbeliDao;
    }
}
