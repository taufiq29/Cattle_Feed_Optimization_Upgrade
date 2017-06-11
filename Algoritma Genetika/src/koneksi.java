
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Muhammad
 */
public class koneksi {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    void testkoneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sapipotong", "root", "");
            JOptionPane.showMessageDialog(null, " mantap koneksi berhasil kawan");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal");
        }
    }

    public static void main(String[] args) {
        koneksi test = new koneksi();
        test.testkoneksi();
        System.exit(0);
    }
}
