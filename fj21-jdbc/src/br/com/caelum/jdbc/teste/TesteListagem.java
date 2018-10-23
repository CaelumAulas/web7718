package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {
		
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.lista();
		
		for(Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endreco: " + contato.getEndereco());
			System.out.println("----------------\n");
		}
		
		/*while(rs.next()) {
				
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			
			System.out.println("Nome: " + nome + 
					", Email: " + email);
		}*/
		
		
	}
}







