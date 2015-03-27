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
<title><fmt:message key="list" bundle="${lang}"/></title>
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
				<a href="controller?page=list&amp;locale=en">En</a>&nbsp;
				<a href="controller?page=list&amp;locale=ru">Ru</a>
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
			<li><a href="controller?page=manager"><fmt:message key="back" bundle="${lang}"/></a></li>
		</ul>
		</div>
</div>

<div id="right">
	<div id="search">
	<form name="form" method="post" action="controller">
		<input type="hidden" name="command" value="list"/>
		<ul>
	<li>	<fmt:message key="model" bundle="${lang}"/>:</li>
	<li><input type="text" name="searchParamName" size="10" />
		<input type="submit" value="<fmt:message key="search" bundle="${lang}"/>"/></li>
		</ul>
	</form>
	<form name="form" method="post" action="controller">
		<input type="hidden" name="command" value="list"/>
		<ul>
	<li>	<fmt:message key="description" bundle="${lang}"/>:</li>
		<li><input type="text" name="searchParamDesc" size="10"/>
		<input type="submit" value="<fmt:message key="search" bundle="${lang}"/>"/></li>
		</ul>
	</form>
	</div>

</div>
<div id="content">
<h2><fmt:message key="list" bundle="${lang}"/></h2>
	<div id="container2">
		<c:forEach var="products" items="${products}">
			<div>	
				&nbsp;${products.getId()}&nbsp;
				&nbsp;${products.getType().getTypeName()}&nbsp;
				&nbsp;${products.getBrand().getBrandName()}
				&nbsp;${products.getName()}&nbsp;${products.getCost()}&nbsp;
				<a href="controller?command=list&delete=<c:out value="${products.getId()}"/>">
				<fmt:message key="delete" bundle="${lang}"/></a><br />
				${products.getDescription()}				
			</div>
		</c:forEach>
	</div>


</div>


<div id="footer">
	
</div>

</div>

</body>
</html>