// Inserindo novos dados no Banco de Dados;

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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES (?, ?, ?, ?, ?);", 
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, "Michael Scott");
			ps.setString(2, "amazingscott@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("15/02/1985").getTime()));
			ps.setDouble(4, 5500.00);
			ps.setInt(5, 4);
			
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
		} catch(ParseException e) {
			e.getMessage();
		}finally {
			DB.closeStatement(ps);
			DB.getConnection();
		}
		
		
	}

}
