// Atualizando Dados do Banco de Dados

package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?);", 
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setDouble(1, 350.0);
			ps.setInt(2, 4);
			
			int rowsAffected = ps.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
			if(rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Id: " + id);
				}
			} else {
				System.out.print("No rows affected");
			}
			
		} catch(SQLException e) {
			e.getMessage();
		}finally {
			DB.closeStatement(ps);
			DB.getConnection();
		}
		
		
	}

}
