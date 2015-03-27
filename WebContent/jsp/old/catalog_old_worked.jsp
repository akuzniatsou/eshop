<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<fmt:setLocale value="${loc}"/><fmt:setBundle basename="web" var="lang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title><fmt:message key="product.list" bundle="${lang}"/></title>
<link rel="stylesheet" href="./css/style1.css" type="text/css"/>
</head>
<body>

	<div id="top">
		<div id="top"></div>
		<div id="mid">
			<h2><fmt:message key="menu" bundle="${lang}"/></h2>
			<ul id="subnav">
				<li><a href="controller?command=index"><fmt:message key="main" bundle="${lang}"/></a></li>
			</ul>
			<h2><fmt:message key="catalog" bundle="${lang}"/></h2>
			<table>
				<tr>
					<td>&nbsp;</td>
					<td>#</td>
					<td><fmt:message key="type" bundle="${lang}"/></td>
					<td><fmt:message key="brand" bundle="${lang}"/></td>
					<td><fmt:message key="model" bundle="${lang}"/></td>
					<td><fmt:message key="cost" bundle="${lang}"/></td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="products" items="${products}">
					<tr>
						<td>&nbsp;</td>
						<td>${products.getId()}</td>
						<td>${products.getType().getTypeName()}</td>
						<td>${products.getBrand().getBrandName()}</td>
						<td>${products.getName()}</td>
						<td>${products.getCost()}</td>
						<td><a
							href="controller?command=description&idProduct=<c:out value="${products.getId()}"/>">
							<fmt:message key="description" bundle="${lang}"/></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div id="bot"></div>
</body>
</html>
