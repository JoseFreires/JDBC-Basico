// Deletando Dados do Banco de Dados

package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("DELETE FROM seller "
					+ "WHERE "
					+ "Id = ?");
			
			ps.setInt(1, 1);
			
			int rowsAffected = ps.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
			
			
		} catch(SQLException e) {
			throw new db.DbIntegrityException(e.getMessage());
		}finally {
			DB.closeStatement(ps);
			DB.getConnection();
		}
		
		
	}

}
