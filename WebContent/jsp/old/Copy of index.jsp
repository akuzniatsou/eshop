<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${loc}"/><fmt:setBundle basename="web" var="lang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html><head>
<title><fmt:message key="main" bundle="${lang}"/></title>

<script src="./js/script1.js"></script></head><body>

<form name="form" method="post" action="controller" onsubmit="javascript:return validate();">
<table width="100%" border="1" style="border-collapse:collapse;">
<tr>
	<td colspan=5 align="left" width="100%">
		<h1><fmt:message key="webshop" bundle="${lang}"/></h1>
	</td>
</tr>
<tr>
	<td align="left" width="25%">
		<input type="hidden" name="command" value="login"/>
		<input type="text" name="login" />
		<fmt:message key="username" bundle="${lang}"/>:
	</td>
	<td align="left" width="20%">
		<input type="password" name="pass"/>
		<fmt:message key="password" bundle="${lang}"/>:
	</td>
	<td align="left" width="25%">
		<input type="submit" value="<fmt:message key="login" bundle="${lang}"/>"/>
	</td>
	<td align="right">
		<fmt:message key="entry" bundle="${lang}"/>
		<fmt:message key="guest" bundle="${lang}"/>
	</td>
	<td align="right">
		<fmt:message key="language" bundle="${lang}"/>:&nbsp;
		<a href="controller?command=index&amp;locale=en">En</a>&nbsp;
		<a href="controller?command=index&amp;locale=ru">Ru</a>
	</td>
</tr>
<tr>
	<td height="600" style="vertical-align:top">
		<h2><fmt:message key="menu" bundle="${lang}"/></h2>
		<ul id="subnav">
			<li><a href="controller?page=reg"><fmt:message key="reg" bundle="${lang}"/></a></li>
			<li><a href="controller?page=info"><fmt:message key="info" bundle="${lang}"/></a></li>
			<li><a href="controller?page=contact"><fmt:message key="contact" bundle="${lang}"/></a></li>
			<li><a href="controller?page=help"><fmt:message key="help" bundle="${lang}"/></a></li>
		</ul>
	</td>
	<td colspan=4 style="vertical-align:top">
			<c:if test="${not empty error}"><fmt:message key="incorrect" bundle="${lang}"/></c:if>
	</td>
</tr></table></form></body></html>