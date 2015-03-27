<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${loc}"/><fmt:setBundle basename="web" var="lang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<link rel="stylesheet" href="./css/style.css" type="text/css"/>
	<script src="./js/script1.js"></script>
	<%-- PAGE TITLE --%>
<title><fmt:message key="catalog" bundle="${lang}"/></title>
</head>
<body>


<div id="maket">


<div id="header">
		<div id="logo">
		<h1><fmt:message key="webshop" bundle="${lang}"/></h1>
		</div>
</div>
<div id="navi">
		
		<div id="local">	
			<div id="local1">	
				<fmt:message key="language" bundle="${lang}"/>:&nbsp;
				<a href="controller?page=catalog&amp;locale=en">En</a>&nbsp;
				<a href="controller?page=catalog&amp;locale=ru">Ru</a>
			</div>
		</div>
		
		
		<div id="welcome">
			<div id="welcome1">
				<fmt:message key="entry" bundle="${lang}"/>
				<fmt:message key="${role}" bundle="${lang}"/>			
			</div>
		</div>
		
		<div id="login">
			<fmt:message key="welcome" bundle="${lang}"/>:	${user}
			<a href="controller?command=logout"><fmt:message key="logout" bundle="${lang}"/></a>
		</div>

</div>
<div id="left">
		<div id="left_menu">
		<h2><fmt:message key="menu" bundle="${lang}"/></h2>
		<ul id="subnav">
			<li><a href="controller?page=customer"><fmt:message key="back" bundle="${lang}"/></a></li>
			<li><a href="controller?commang=cart"><fmt:message key="cart" bundle="${lang}"/></a></li>
		</ul>
		</div>
</div>

<div id="right">
	<div id="search">
	<form name="form" method="post" action="controller">
		<input type="hidden" name="command" value="catalog"/>
		<ul>
	<li>	<fmt:message key="model" bundle="${lang}"/>:</li>
	<li><input type="text" name="searchParamName" size="10" />
		<input type="submit" value="<fmt:message key="search" bundle="${lang}"/>"/></li>
		</ul>
	</form>
	<form name="form" method="post" action="controller">
		<input type="hidden" name="command" value="catalog"/>
		<ul>
	<li>	<fmt:message key="description" bundle="${lang}"/>:</li>
		<li><input type="text" name="searchParamDesc" size="10"/>
		<input type="submit" value="<fmt:message key="search" bundle="${lang}"/>"/></li>
		</ul>
	</form>
	</div>

</div>
<div id="content">
<h2><fmt:message key="catalog" bundle="${lang}"/></h2>
	<div id="container1">
		<c:forEach var="products" items="${products}">
			<div>	
				<p align="left" id="type"><span>
				${products.getId()}&nbsp;&nbsp;${products.getType().getTypeName()}</span></p>
				<p id="model"><span>${products.getBrand().getBrandName()}&nbsp;${products.getName()}</span></p>
				<p>${products.getDescription()}</p>
				<p align=right id="cost"><span>${products.getCost()}$</span></p>
				<a href="controller?command=catalog&addCart=<c:out 
				value="${products.getId()}"/>">
				<fmt:message key="toCart" bundle="${lang}"/></a>
			</div>
		</c:forEach>
	</div>


</div>


<div id="footer">
	
</div>

</div>

</body>
</html>