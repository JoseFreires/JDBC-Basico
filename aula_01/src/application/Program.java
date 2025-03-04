// Criando conexão com o Banco de Dados

package application;

import java.sql.Connection;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		DB.closeConnection();
		System.out.print("Deu certo!");
	}

}
