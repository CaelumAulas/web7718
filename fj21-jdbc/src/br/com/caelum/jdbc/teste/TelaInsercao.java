package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TelaInsercao {

	public static void main(String[] args) throws SQLException {
		
		Contato c = new Contato();
		c.setNome("Felix");
		c.setEndereco("Rua V.");
		c.setEmail("lucas@caelum.com.br");
		c.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.insere(c);
	}
}
