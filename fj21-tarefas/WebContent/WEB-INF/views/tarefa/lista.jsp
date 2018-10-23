<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de tarefas</title>
</head>
<body>
	
	<head>
		<script src="js/jquery.js"></script>
	</head>
	
	<h3>Tarefas do ${usuarioLogado.login}</h3>
	
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalizado?</th>
				<th>Data de finalização</th>
			</tr>
		</thead>
		
		<c:forEach items="${listaTarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizada!</td>
				</c:if>
								
				<c:if test="${tarefa.finalizado eq false}">
					<td id="tarefa_${tarefa.id}">
						<a href="#" onclick="finalizaTarefa(${tarefa.id})">
							Finalizar agora!
						</a>
					</td>
				</c:if>
				
				<td>
					<fmt:formatDate pattern="dd/MM/yyyy" 
						value="${tarefa.dataFinalizacao.time}" />
				</td>
				<td>
					<a href="removeTarefa?id=${tarefa.id}">Remover</a>
				</td>
				<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	<script>
		function finalizaTarefa(idTarefa) {
			$.get("finalizaTarefa?id=" + idTarefa, function() {
				$("#tarefa_" + idTarefa).html("Finalizada!");
			});
		}
	</script>
</body>
</html>