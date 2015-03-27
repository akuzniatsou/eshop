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
<title><fmt:message key="administrator" bundle="${lang}"/></title>
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
				<a href="controller?page=userList&amp;locale=en">En</a>&nbsp;
				<a href="controller?page=userList&amp;locale=ru">Ru</a>
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
			<li><a href="controller?page=admin"><fmt:message key="back" bundle="${lang}"/></a></li>
		</ul>
		</div>
</div>

<div id="right">
	

</div>
<div id="content">
	
	<h2><fmt:message key="listUser" bundle="${lang}"/></h2>
	<div id="container3">
		<c:forEach var="users" items="${users}">
			<div id="${users.getRole().getRoleName()}">	
			<span><fmt:message key="${users.getRole().getRoleName()}" bundle="${lang}"/><br /></span>
				<fmt:message key="id" bundle="${lang}"/>:&nbsp;${users.getId()}<br />
				<fmt:message key="userLogin" bundle="${lang}"/>:&nbsp;${users.getLogin()}<br />
				<fmt:message key="name" bundle="${lang}"/>:&nbsp;${users.getPerson().getName()}<br />
				<fmt:message key="surname" bundle="${lang}"/>:&nbsp;${users.getPerson().getSurname()}<br />
				<fmt:message key="email" bundle="${lang}"/>:&nbsp;${users.getPerson().getEmail()}<br />
				<fmt:message key="address" bundle="${lang}"/>:&nbsp;${users.getPerson().getAddress()}<br />
				<fmt:message key="phone" bundle="${lang}"/>:&nbsp;${users.getPerson().getPhone()}<br />
				<a href="controller?command=listUser&delete=<c:out value="${users.getId()}"/>">
				<fmt:message key="delete" bundle="${lang}"/></a>
			</div>
		</c:forEach>
	</div>

</div>


<div id="footer">
	
</div>

</div>

</body>
</html>