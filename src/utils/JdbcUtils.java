package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
    private static Connection conn;
    
    public static Connection getConnection()
    {
        if (conn != null) {
            return conn;
        }
        
        // Khởi tạo connection
        try {
            // B1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // B2: Tạo kết nối CSDL
            String username = "sa", password = "Aa@123456",
                url = "jdbc:sqlserver://localhost:1433;databaseName=SOF2041";
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
        }
    }
}
