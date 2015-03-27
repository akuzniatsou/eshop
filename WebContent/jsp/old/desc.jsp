<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${loc}"/><fmt:setBundle basename="web" var="lang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" href="./css/style1.css" type="text/css"/>
</head>
<body>
<c:set var ="product" value="${product}"/>
<div id="top"></div>
<div id="mid">
		<h2>Меню</h2>
		<ul id="subnav">
        <li><a href="controller?command=catalog"><fmt:message key="catalog" bundle="${lang}"/></a></li>
        <li><a href="controller?command=index"><fmt:message key="main" bundle="${lang}"/></a></li>

		</ul>
	<h2>Описание продукта</h2>
<table>

<tr><td><h3>${product.getType().getTypeName()}</h3></td></tr>
<tr><td>${product.getBrand().getBrandName()}&nbsp;&nbsp;&nbsp;${product.getName()}</td></tr>
<tr><td><fmt:message key="cost" bundle="${lang}"/>:&nbsp;${product.getCost()}&nbsp;$</td></tr>
<tr><td>${product.getDescription()}</td></tr>
<tr><td><a href="controller?command=addCart&idProduct=<c:out value="${product.getId()}"/>">В корзину</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="controller?command=catalog">Каталог</a></td></tr>

</table>



</div>
 <div id="bot"></div>
</body>
</html>
