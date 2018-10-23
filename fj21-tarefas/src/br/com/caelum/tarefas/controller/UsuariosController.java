package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class UsuariosController {

	@Autowired
	private JdbcUsuarioDao usuarioDao;

	@RequestMapping("formLogin")
	public String formLogin() {
		return "usuario/login";
	}
	
	@RequestMapping("login")
	public String realizaLogin(Usuario usuario, HttpSession session) {
		
		boolean existeUsuario = usuarioDao.existeUsuario(usuario);
		
		if(existeUsuario == false) {
			return "forward:formLogin";
		} else {
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:listaTarefas";
		}
	}
}
