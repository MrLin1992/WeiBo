package utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

    private static ComboPooledDataSource pool = null;

    static {
        try {
            pool = new ComboPooledDataSource();
            pool.setDriverClass("org.postgresql.Driver");
            pool.setJdbcUrl("jdbc:postgresql://localhost:5432/weibo");
            pool.setUser("postgres");
            pool.setPassword("postgres");
            pool.setMaxPoolSize(30);
            pool.setMinPoolSize(5);
            pool.setInitialPoolSize(10);
        } catch (Exception e) {
        }
    }

    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
