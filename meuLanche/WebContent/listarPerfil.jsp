<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MeuLanche</title>
<style type="text/css"><%@ include file="/dash/theme.css" %></style>
</head>

<body>
<section class="wm-topheader"><div class="wm-th"><span>MeuLanche JP</span></div></section>

<section class="wm-content">
<div class="wm-box">
<form method="post" action="/meuLanche/cliente.jsp">
	<input type="submit" value="voltar">
</form>

Bem-vindo ${clienteLogado.nome}<br><br>

<form method="post" action="/meuLanche/">
	<input type="submit" value="Cadastrar novo">
</form><br><br>

<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633"> 
<tr><td>Nome</td><td>Usuário</td><td>CPF</td><td>Email</td><td>Idade</td><td>Promoção</td><td>Bairro</td>
<td>Cidade</td><td>Rua</td><td>Complemento</td><td>Número</td></tr>	
    <tr>
      <td>${usuario.nome}</td>
      <td>${usuario.userName}</td>
      <td>${usuario.cpf}</td>
      <td>${usuario.email}</td>
      <td>${usuario.idade}</td>
      <td>${usuario.grupo.promocao.nome}</td>          
      <td>${usuario.endereco.bairro}</td>
      <td>${usuario.endereco.cidade}</td>
      <td>${usuario.endereco.rua}</td>
      <td>${usuario.endereco.complemento}</td>
      <td>${usuario.endereco.numero}</td>
      

      <td><a href="/meuLanche/cadastro_cliente?id=${cliente.id}">Editar</a></td>
     </tr>
</table>

<form action="/meuLanche/exclusao_usuario?id=${cliente.id}" method="get">
	<input type="submit" value="Excluir" />
</form>
</div>
</section>

<section class="wm-footer">
<span>© 2018 - Grupo MeuLanche. Todos os direitos reservados.</span>
</section>

</body>
</html>




