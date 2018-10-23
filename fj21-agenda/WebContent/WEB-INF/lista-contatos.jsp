<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de contatos</title>
</head>
<body>

	<c:import url="cabecalho.jsp" />
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Endereco</th>
				<th>Email</th>
				<th>Data de nascimento</th>
			</tr>
		</thead>

		<c:forEach items="${contatos}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.nome}</td>
				<td>${c.endereco}</td>


				<c:if test="${not empty c.email}">
					<td><a href="mailto:${c.email}">${c.email}</a></td>
				</c:if>
				<c:if test="${empty c.email}">
					<td>Não informou o email</td>
				</c:if>


				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${c.dataNascimento.time}" /></td>

				<td><a href="mvc?logica=RemoveContatoLogic&id=${c.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>