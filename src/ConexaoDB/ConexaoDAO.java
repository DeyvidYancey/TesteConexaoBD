/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Deyvid
 */
public class ConexaoDAO {
    
    public static Connection conectaBD() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/mercadinho?user=root&password=12345678&serverTimezone=UTC & characterEncoding = UTF-8 & useUnicode = yes";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return conn;
	}
}
