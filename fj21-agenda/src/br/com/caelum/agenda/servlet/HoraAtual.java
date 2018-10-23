package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/horaAtual")
public class HoraAtual extends HttpServlet {

	public void service(HttpServletRequest resquest, HttpServletResponse response) throws IOException {
		
		PrintWriter writer = response.getWriter();
		
		Calendar horaAtual = Calendar.getInstance();
		
		writer.println("<html>"
				+ "<head><title>Hora atual</title></head>"
				+ "<body>"
				+ "<h1>" + horaAtual.getTime() + "</h1></body></html>");
	}
}


