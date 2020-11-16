package LAP5;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class B1 {

    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from STUDENTS";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getString("Masv") + ", ");
                System.out.print(rs.getString("Hoten") + ", ");
                System.out.print(rs.getString("Email") + ", ");
                System.out.print(rs.getString("Sdt") + ", ");
                System.out.println(rs.getString("Gioitinh"));

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
