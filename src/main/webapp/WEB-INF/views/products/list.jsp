<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>

<template:page title="Listagem de Produtos">
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="user"/>
		<div>Olá ${user.name}</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<c:url value="/products/form" var="formLink"/>
		<a href="${formLink}">Cadastrar novo Produto</a>
	</sec:authorize>
	${sucesso}
	<h3 style="float: left; position: relative; left: 60px;">Itens no Carrinho: ${shoppingCart.quantity} - Subtotal: ${shoppingCart.total}</h3>
	<h3 style="float: right; position: relative; right: 60px;"><a href="/casadocodigo/shopping">Finalizar Compras</a></h3>
	<main class="container">
		<display:table name="products" id="book" class="table">
			<display:column property="id" title="ID"/>
			<display:column title="Título">
				<a href="/casadocodigo/products/${book.id}">${book.title}</a>
			</display:column>
			<display:column property="description" title="Descrição"/>
			<display:column property="numberOfPages" title="Páginas"/>
			<display:column title="Preços">
				<c:forEach items="${book.prices}" var="price">
					${price.bookType}: R$ ${price.value}<br>
				</c:forEach>
			</display:column>
		</display:table>
	</main>
</template:page>