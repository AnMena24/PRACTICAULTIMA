package infraestructura;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author david
 */
public class ConexionDB {
    private static final String URL =
        "jdbc:sqlserver://localhost:1433;databaseName=CafeteriaUTN;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "Jefferson365";

    public static Connection get() throws Exception {
        // Asegura que el driver esté cargado
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

}