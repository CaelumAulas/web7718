package br.com.caelum.jdbc.teste;

public class TestaLogin {

	public static void main(String[] args) {
		
		// SQL Injection
		String login = "joana_d'arc";
		String senha = "123";
		
		String sql = "select * from usuarios where login = '" 
				+ login + "' and senha = '" + senha + "'";
		
		System.out.println(sql);
	}
}
