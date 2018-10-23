package br.com.caelum.tarefas;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		System.out.println("conectando ...");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21",
					"root", "caelum");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
