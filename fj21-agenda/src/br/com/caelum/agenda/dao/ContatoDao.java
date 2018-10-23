package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.agenda.modelo.Contato;

public class ContatoDao {

	private Connection conexao;

	public ContatoDao(Connection conexaoRecebida) {
		this.conexao = conexaoRecebida;
	}

	public void insere(Contato contato) {

		try {
			String sql = "insert into contatos(nome, email, endereco, dataNascimento) " + "values(?, ?, ?, ?)";

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());

			Calendar calendar = contato.getDataNascimento();
			long tempo = calendar.getTimeInMillis();
			stmt.setDate(4, new Date(tempo));

			stmt.execute();

			stmt.close();
			
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() throws SQLException {

		String sql = "select * from contatos";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		List<Contato> contatos = new ArrayList<>();

		while (rs.next() == true) {

			Contato c = new Contato();
			c.setId(rs.getLong("id"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setEndereco(rs.getString("endereco"));

			Calendar dataNascimento = Calendar.getInstance();
			Date dataDoBanco = rs.getDate("dataNascimento");
			dataNascimento.setTime(dataDoBanco);

			c.setDataNascimento(dataNascimento);

			contatos.add(c);
		}

		return contatos;
	}
	
	public void exclui(Contato contato) {
		
		try {
			String sql = "delete from contatos where id =?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
