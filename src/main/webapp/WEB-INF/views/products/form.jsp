<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
		<title>Cadastro de Livros</title>
	</head>
	<body>
		<c:url value="/products" var="url"/>
		<form action="${url}" method="post">
			<table class="table">
				<tr>
					<td><label for="title">Título</label></td>
					<td><input name="title" id="title" type="text"/></td>
				</tr>
				<tr>
					<td><label for="description">Descrição</label></td>
					<td><textarea name="description" id="description" rows="10" cols="20"></textarea></td>
				</tr>
				<tr>
					<td><label for="numberOfPages">Número de Páginas</label></td>
					<td><input name="numberOfPages" id="numberOfPages" type="text"/></td>
				</tr>				
			</table>
			<input type="submit" value="Salvar"/>
		</form>
	</body>
</html>