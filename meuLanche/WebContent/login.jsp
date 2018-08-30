<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MeuLanche Login</title>
<style type="text/css"><%@ include file="/dash/theme.css" %></style>
</head>
<body>
<c:if test="${mensagemExclusao != null}">
	<span style="color:red">${mensagemExclusao}</span>
</c:if>
<c:if test="${mensagemErro != null}">
	<span style="color:red">${mensagemErro}</span>
</c:if>
<section class="wm-topheader"><div class="wm-th"><span>MeuLanche JP</span></div></section>

<section class="wm-content">
<div class="wm-box-light">
<form action="/meuLanche/login" method="post">
	<span>Usuário</span><br><input type="text" name="username" /><br>
	<span>Senha</span><br><input type="password" name="senha" />
	<br><input type="submit" value="Entrar" />
</form>

<div class="wm-separator"></div>

<form action="/meuLanche/login" method="get">
	<input type="submit" value="Cadastrar novo usuário" />
</form>
</div>
</section>

<section class="wm-footer">
<span>© 2018 - Grupo MeuLanche. Todos os direitos reservados.</span>
</section>

</body>
</html>
