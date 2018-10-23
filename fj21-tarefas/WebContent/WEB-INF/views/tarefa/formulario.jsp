<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Tarefa</title>
</head>
<body>
	<form action="adicionaTarefa" method="post">
		Descrição:<br>
		<textarea name="descricao"></textarea><br>
		<form:errors path="tarefa.descricao"/>
		<input type="submit" value="Salvar tarefa">
	</form>
</body>
</html>