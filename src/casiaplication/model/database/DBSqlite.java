package casiaplication.model.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciacelo
 */
public class DBSqlite {
    private Connection connection;

  
    public Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/ciace/Documents/DataBase/Teste.db");
            return this.connection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBSqlite.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
