<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
		<title>Cadastro de Livros</title>
	</head>
	<body>
		<c:url value="/products" var="url"/>
		<main class="container">
		<form:form action="${spring:mvcUrl('PC#save').build()}" method="post" commandName="product" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<td><label for="title">Título</label></td>
					<td><form:input path="title" id="title" type="text"/></td>
					<td><form:errors path="title"/></td>
				</tr>
				<tr>
					<td><label for="description">Descrição</label></td>
					<td><form:textarea path="description" id="description" rows="10" cols="20"/></td>
					<td><form:errors path="description"/></td>
				</tr>
				<tr>
					<td><label for="numberOfPages">Número de Páginas</label></td>
					<td><form:input path="numberOfPages" id="numberOfPages" type="text"/></td>
					<td><form:errors path="numberOfPages"/></td>
				</tr>
				<tr>
					<td><label for="summary">Sumário do Livro</label></td>
					<td><input name="summary" id="summary" type="file"/></td>
					<td><form:errors path="summaryPath"/></td>
				</tr>
				<tr>
					<td><label for="releaseDate">Data de Lançamento</label></td>
					<td><form:input path="releaseDate" type="date" id="releaseDate"/></td>
					<td><form:errors path="releaseDate"/></td>
				</tr>
				<c:forEach items="${types}" var="bookType" varStatus="status">
					<tr>
						<td><label for="price_${bookType}">${bookType}</label></td>
						<td><input name="prices[${status.index}].value" type="text" id="price_${bookType}"/></td>
						<td><input name="prices[${status.index}].bookType" type="hidden" value="${bookType}"/></td>
					</tr>
				</c:forEach>		
			</table>
			<input type="submit" value="Salvar"/>
		</form:form>
		</main>
	</body>
</html>