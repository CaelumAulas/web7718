<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %> 
<html>
	<head>
		<meta charset="utf-8">
		<title>Novo contato</title>
		
		<link rel="stylesheet" href="css/jquery.css">
		
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
	
		<h1>Cadastro de contatos</h1>
		
		<form action="adicionaContato" method="post">
			Nome: <input type="text" name="nome"><br>
			Email: <input type="text" name="email"><br>
			Endereço: <input type="text" name="endereco"><br>
								
			Data de nascimento: <caelum:campoData id="dataNasc" /> <br>
			<button>Salvar</button>
		</form>
				
		<c:import url="rodape.jsp" />
	</body>
</html>