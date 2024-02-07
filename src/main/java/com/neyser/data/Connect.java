package com.neyser.data;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Connect
{
    // Declaración de las constantes para la cadena de conexión
    // Puerto para Windows (Xampp): JDBC_PORT="3306"
    // Puerto para macOS (Mamp): JDBC_PORT="8889"
    private static final String JDBC_SERVER = "localhost";
    private static final String JDBC_PORT = "3306";
    private static final String JDBC_UTC = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_DATABASE = "bd1";
    private static final String JDBC_USER = "neyser";
    private static final String JDBC_PASSWORD = "madrid";
    // Cadena de conexión
    private static final String JDBC_URL = "jdbc:mysql://" + JDBC_SERVER + ":" + JDBC_PORT +"/" + JDBC_DATABASE + JDBC_UTC;

    // Método que inicializa el agrupamiento de conexiones
    // para gestionar las conexiones que vayan solicitando
    // el método getConnection()

    public static DataSource getDataSource()
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        // Definición inicial del número de conexiones
        ds.setInitialSize(5);
        return ds;
    }

    // Metodo para obtener la conexión a través del agrupamiento de conexiones
    // llamando al método "getDataSource"
    public static Connection getConnection() throws SQLException
    {
        return getDataSource().getConnection();
    }

    // Sobrecarga de métodos close para el cierre de objetos
    public static void close(ResultSet rs)
    {
        try
        {
            rs.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt)
    {
        try
        {
            stmt.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn)
    {
        try
        {
            conn.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
}
