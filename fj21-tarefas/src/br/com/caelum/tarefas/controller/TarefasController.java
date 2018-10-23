package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	private JdbcTarefaDao tarefaDao;
	
	//IoC - inversão de controle
	// Injeçao de dependencias
	@Autowired
	public TarefasController(JdbcTarefaDao dao) {
		this.tarefaDao = dao;
	}
	
	@RequestMapping("/novaTarefa")
	public String formulario() {
		return "tarefa/formulario";
	}

	@RequestMapping("/adicionaTarefa")
	public String novaTarefa(@Valid Tarefa tarefa, BindingResult result) {

		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		tarefaDao.adiciona(tarefa);

		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public String listaTarefas(Model model) {
	
		List<Tarefa> tarefas = tarefaDao.lista();

		/*
		 * ModelAndView mv = new ModelAndView("tarefa/lista"); mv.addObject("tarefas",
		 * tarefas);
		 */

		model.addAttribute("listaTarefas", tarefas);

		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		System.out.println(tarefa.getId());

		tarefaDao.remove(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", tarefaDao.buscaPorId(id));
		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		tarefaDao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) {
		tarefaDao.finaliza(id);
	}
}
