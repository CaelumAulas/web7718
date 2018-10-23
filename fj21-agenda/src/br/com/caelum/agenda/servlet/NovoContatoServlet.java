package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class NovoContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataTexto = req.getParameter("dataNasc");

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;

		try {
			data = sdf.parse(dataTexto);
		} catch (ParseException e) {
			out.print("Erro na conversão da data");
		}

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);

		contato.setDataNascimento(dataNascimento);

		Connection connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		dao.insere(contato);

		RequestDispatcher rd = req.getRequestDispatcher("contato-adicionado.jsp");
		rd.forward(req, resp);
	}
}
