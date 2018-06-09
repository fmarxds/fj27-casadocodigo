<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
		<title>Listagem de Livros</title>
	</head>
	<body>
		${sucesso}
		<display:table name="products" id="book" class="table">
			<display:column property="id" title="ID"/>
			<display:column property="title" title="Título"/>
			<display:column property="description" title="Descrição"/>
			<display:column property="numberOfPages" title="Páginas"/>
			<display:column title="Preços">
				<c:forEach items="${book.prices}" var="price">
					${price.bookType}: ${price.value}<br>
				</c:forEach>
			</display:column>
		</display:table>
	</body>
</html>