// Realizando o tratamento de transações.
// Caso ocorra um erro em uma das execuções devemos tratar ele de forma que pare totalmente todos aqueles 
// que ocorreram anteriormente. Assim, se tornando mais seguro.

package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		
		try {
			
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET baseSalary = 2020 WHERE DepartmentId = 1");
			
			// Criando um erro falso para demonstrar o tratamento que ocorre.
			int x = 1;
			if(x < 2) {
				throw new SQLException("Fake Error!");
			}
			
			
			int rows2 = st.executeUpdate("UPDATE seller SET baseSalary = 3020 WHERE DepartmentId = 2");
			
			System.out.printf("Rows Affected: ", rows2 + rows1);
			
			conn.commit();
			
			
		} catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying rollback! Caused by: " + e1.getMessage());
			}
		}finally {
			DB.closeStatement(st);
			DB.getConnection();
		}
		
		
	}

}
