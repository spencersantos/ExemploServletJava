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

<div class="wm-box-title">Insira os dados abaixo para participar de uma promoção.</div>

<div class="wm-ls">
<form method="post" action="/meuLanche/paarticipar_promocao">
	
Nome<input type="text" name="nome" value="${usuario.nome}"/><br>
CPF<input type="text" name="cpf" value="${usuario.cpf}"/><br>
Email<input type="text" name="email" value="${usuario.email}"/><br>
Idade<input type="text" name="idade" value="${usuario.idade}"/><br>
Cidade<input type="text" name="cidade" value="${usuario.endereco.cidade}"/><br>
Bairro<input type="text" name="bairro" value="${usuario.endereco.bairro}"/><br></div>
<div class="wm-rs">Rua<input type="text" name="rua" value="${usuario.endereco.rua}"/><br>
Número<input type="text" name="numero" value="${usuario.endereco.numero}"/><br>
Complemento<input type="text" name="complemento" value="${usuario.endereco.complemento}"/>

<div class="wm-separator"></div>

<input type="submit" value="Adicionar">
</div>
</form>
</div>
</section>

<section class="wm-footer">
<span>© 2018 - Grupo MeuLanche. Todos os direitos reservados.</span>
</section>

</body>
</html>