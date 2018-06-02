<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Livros</title>
	</head>
	<body>
		<c:url value="/products" var="url"/>
		<form action="${url}" method="post">
			<div>
				<label for="title">Título</label>
				<input name="title" id="title" type="text"/>
			</div>
			<div>
				<label for="description">Descrição</label>
				<textarea name="description" id="description" rows="10" cols="20"></textarea>
			</div>
			<div>
				<label for="numberOfPages">Número de Páginas</label>
				<input name="numberOfPages" id="numberOfPages" type="text"/>
			</div>
			<div>
				<input type="submit" value="Salvar"/>
			</div>
		</form>
	</body>
</html>