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
<form method="post" action="/meuLanche/usuario">
	<input type="submit" value="Ver Perfil">
</form>

<form method="get" action="/meuLanche/usuario">
	<input type="submit" value="Cadastrar Promoção">
</form>

<form method="post" action="/meuLanche/exclusao_usuario">
	<input type="submit" value="Desconectar">
</form>

</div>
</section>

<section class="wm-footer">
<span>© 2018 - Grupo MeuLanche. Todos os direitos reservados.</span>
</section>

</body>
</html>