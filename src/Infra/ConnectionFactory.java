
package Infra;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    private ConnectionFactory() {}
    
    public static Connection conectaBanco() throws Exception {

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                ""
        );
    }
}
