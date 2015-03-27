<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${loc}"/><fmt:setBundle basename="web" var="lang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head><title><fmt:message key="administrator" bundle="${lang}"/></title></head>
<body>

<table width="100%" border="1" style="border-collapse:collapse;">
<tr>
	<td colspan=5 align="left" width="100%">

		<h1>mainAdminPage.jsp</h1>
	</td>
</tr>

<tr>
	<td height="600" style="vertical-align:top">
			<h2><fmt:message key="menu" bundle="${lang}"/></h2>
		<ul>
			<li><a href="controller?command=listUser">Browse user</a></li>
			<li><a href="controller?command=addUser">Add user</a></li>
			</ul>
	</td>
	
	<c:forEach var="client" items="${users}">
					<tr height="35">
						<td>${client.getLogin()}</td>
				</c:forEach>
	<td colspan=4 style="vertical-align:top">


	</td>
</tr></table></body></html>