<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${loc}"/><fmt:setBundle basename="web" var="lang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head><title><fmt:message key="manager" bundle="${lang}"/></title></head>
<body>
<table width="100%" border="1" style="border-collapse:collapse;">
<tr>
	<td colspan=5 align="left" width="100%">
<%-- 		<h1><fmt:message key="webshop" bundle="${lang}"/></h1> --%>
		<h1>mainAdminPage.jsp</h1>
	</td>
</tr>
<tr>
	<td align="left" width="20%">
		<fmt:message key="welcome" bundle="${lang}"/>:	${user}
		<a href="controller?command=logout"><fmt:message key="logout" bundle="${lang}"/></a>
	</td>
	<td align="center" width="27%">
	</td>
	<td align="center" width="25%"></td>
	<td align="center">
		<fmt:message key="entry" bundle="${lang}"/>
		<fmt:message key="${role}" bundle="${lang}"/>
	</td>
	<td align="right">
		<fmt:message key="language" bundle="${lang}"/>:&nbsp;
		<a href="controller?command=managerList&amp;locale=en">En</a>&nbsp;
		<a href="controller?command=managerList&amp;locale=ru">Ru</a>
	</td>
</tr>
<tr>
	<td height="600" style="vertical-align:top">
		<h2><fmt:message key="menu" bundle="${lang}"/></h2>
		<ul>
<c:if test="${empty users}"><li><a href="controller?command=listUser">Browse user</a></li></c:if>
			<li><a href="controller?command=addUser">Add user</a></li>
		</ul>
	</td>
	<td colspan=4 style="vertical-align:top">
	<c:if test="${users == null}">${errorProducts}</c:if>
<c:if test="${users != null}">
	<h2><fmt:message key="product" bundle="${lang}"/></h2>
			<table>
				<tr>
					<th width="30" align="left">#</th>
					<th width="120" align="left"><fmt:message key="userLogin" bundle="${lang}"/></th>
					<th width="100" align="left"><fmt:message key="password" bundle="${lang}"/></th>
					<th width="180" align="left"><fmt:message key="role" bundle="${lang}"/></th>
					<th width="120" align="left"><fmt:message key="person" bundle="${lang}"/></th>
					<td>&nbsp;</td>
				</tr>
	<c:forEach var="client" items="${users}">
					<tr height="35">
						<td>${client.getId()}</td>
						<td>${client.getLogin()}</td>
						<td>${client.getPassword()}</td>
						<td>${client.getRole()}</td>
						<td>${client.getPerson()}</td>
				</c:forEach>

			</table>
		</c:if>
	</td>
</tr></table>
</body>
</html>