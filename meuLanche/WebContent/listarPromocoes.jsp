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
${clienteLogado.nome} Escolha sua promoção abaixo.<br>

<table border=1 cellspacing=0 cellpadding=2 bordercolor="666633"> 
<tr><td>Nome</td><td>Descrição</td><td>Estabelecimento</td><td>Data Fim</td></tr>	
<c:forEach var="grupo" items="${promocoes}" >
    <tr>
      <td>${grupo.promocao.nome}</td>
      <td>${grupo.promocao.descricao}</td>
      <td>${grupo.promocao.estabelecimento}</td>      
      <td><fmt:formatDate pattern="dd/MM/yyyy" value="${grupo.promocao.dataValidade}"/></td>
      
     </tr>
     <form method="post" action="/meuLanche/SalvarPromocao">
     <input type="hidden" name="idGrupo" value="${grupo.id}">
		Cadastrar:<input type="submit" value="cadastrar">
	</form>
     
</c:forEach>
</table>

</div>
</section>

<section class="wm-footer">
<span>© 2018 - Grupo MeuLanche. Todos os direitos reservados.</span>
</section>

</body>
</html>




