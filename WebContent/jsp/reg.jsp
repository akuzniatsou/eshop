<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${loc}"/><fmt:setBundle basename="web" var="lang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<script src="./js/script1.js"></script>
<script src="./js/script2.js"></script>
	<link rel="stylesheet" href="./css/style.css" type="text/css"/>
	<%-- PAGE TITLE --%>
<title><fmt:message key="reg" bundle="${lang}"/></title>
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
				<a href="controller?page=reg&amp;locale=en">En</a>&nbsp;
				<a href="controller?page=reg&amp;locale=ru">Ru</a>
			</div>
		</div>
		
		
		<div id="welcome">
			<div id="welcome1">
				<fmt:message key="entry" bundle="${lang}"/>
				<fmt:message key="guest" bundle="${lang}"/>
			</div>
		</div>
		
		<div id="login">
			<div>
				
				<form name="form" method="post" action="controller" onsubmit="javascript:return validate();" >
				<input type="hidden" name="command" value="login"/>
				<fmt:message key="username" bundle="${lang}"/><input type="text" name="login" />
				<fmt:message key="password" bundle="${lang}"/><input type="password" name="pass" />
				<input type="submit" value="<fmt:message key="login" bundle="${lang}"/>"/>
				</form>
			</div>
		</div>

</div>
<div id="left">
		<div id="left_menu">
		<h2><fmt:message key="menu" bundle="${lang}"/></h2>
		<ul id="subnav">
			<li><a href="controller?page=index"><fmt:message key="main" bundle="${lang}"/></a></li>
			<li><a href="controller?page=info"><fmt:message key="info" bundle="${lang}"/></a></li>
			<li><a href="controller?page=contact"><fmt:message key="contact" bundle="${lang}"/></a></li>
			<li><a href="controller?page=help"><fmt:message key="help" bundle="${lang}"/></a></li>
		</ul>
		</div>
</div>

<div id="right">

</div>
<div id="content">
	<c:if test="${not empty error}"><fmt:message key="incorrect" bundle="${lang}"/></c:if>
	<h2>Что нужно для регистрации</h2>
	<p>Что бы регистрация прошла успешно, заполните все поля и нажмите на кнопку "Зарегистрироваться"</p>
	<h2><fmt:message key="reg" bundle="${lang}"/></h2>
	
	<form name="form2" method="post" action="controller" onsubmit="javascript:return validate2();">
		<p>
			<fmt:message key="userLogin" bundle="${lang}"/> 
			<input type="hidden" name="command" value="create"/>
			<input type="text" name="alogin" />
		</p>
		<p>
			<fmt:message key="email" bundle="${lang}"/>
			<input type="email" name="aemail" />
		</p>
		<p>
			<fmt:message key="pass" bundle="${lang}"/>
			<input type="password" name="apass" /> 
			<fmt:message key="pass2" bundle="${lang}"/>
			<input type="password" name="apass2" />
		</p>
			<p>
		<button type="submit"><fmt:message key="confirm" bundle="${lang}"/></button>
			</p>
		</form>
</div>


<div id="footer">
	
</div>

</div>

</body>
</html>