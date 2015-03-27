<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${loc}"/><fmt:setBundle basename="web" var="lang"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head><title><fmt:message key="product.list" bundle="${lang}"/></title></head>
<body>

<table width="100%" border="1" style="border-collapse:collapse;">
<tr>
	<td colspan=5 align="left" width="100%">
<%-- 		<h1><fmt:message key="webshop" bundle="${lang}"/></h1> --%>
		<h1>edit.jsp</h1>
	</td>
</tr>
<tr>
	<td align="left" width="20%">
		<fmt:message key="welcome" bundle="${lang}"/>:	${user}
		<a href="controller?command=logout"><fmt:message key="logout" bundle="${lang}"/></a>
	</td>
	<td align="center" width="27%">
	</td>
	<td align="center" width="25%">

	<td align="center">
		<fmt:message key="entry" bundle="${lang}"/>
		<fmt:message key="${role}" bundle="${lang}"/>
	</td>
	<td align="right">
		<fmt:message key="language" bundle="${lang}"/>:&nbsp;
		<a href="controller?command=catalog&amp;locale=en">En</a>&nbsp;
		<a href="controller?command=catalog&amp;locale=ru">Ru</a>
	</td>
</tr>
<tr>
	<td height="600" style="vertical-align:top">
		<h2><fmt:message key="menu" bundle="${lang}"/></h2>
		<ul id="subnav">
			<li><a href="controller?page=customer"><fmt:message key="main" bundle="${lang}"/></a></li>
	<c:if test="${empty user}">	
			<li><a href="controller?page=registration"><fmt:message key="registration" bundle="${lang}"/></a></li>
	</c:if>		
	<c:if test="${not empty user}">	
			<li><a href="controller?page=cart"><fmt:message key="cart" bundle="${lang}"/></a></li>
	</c:if>			
		</ul>
	</td>
	<td colspan=4 style="vertical-align:top">
	<h2><fmt:message key="update" bundle="${lang}"/></h2>
	<form name="form" method="post" action="controller">
			<table>
				<tr>
					<th width="30" align="left">#</th>
					<th width="120" align="left"><fmt:message key="type" bundle="${lang}"/></th>
					<th width="100" align="left"><fmt:message key="brand" bundle="${lang}"/></th>
					<th width="180" align="left"><fmt:message key="model" bundle="${lang}"/></th>
					<th width="120" align="left"><fmt:message key="cost" bundle="${lang}"/></th>
					<th width="100" align="left"><fmt:message key="description" bundle="${lang}"/></th>
				</tr>
				<c:forEach var="products" items="${products}">
					<tr>
						<td>${products.getId()}</td>
						<td>${products.getType().getTypeName()}</td>
						<td>${products.getBrand().getBrandName()}</td>
						<td>${products.getName()}</td>
						<td>${products.getCost()}&nbsp;$</td>
						<td>${products.getDescription()}</td>
					</tr>
					
					<tr>
						<td><input type="hidden" name="command" value="editor"/></td>
						<td><input  type="text" size="15" name="type" /></td>
						<td><input  type="text" size="15" name="brand" /></td>
						<td><input  type="text" size="15" name="name" /></td>
						<td><input  type="text" size="15" name="cost" /></td>
						<td><textarea name="desc" cols="40" rows="3"></textarea></td>
					</tr>
						<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="<fmt:message key="apply" bundle="${lang}"/>" /></td>
						<td><input type="reset" value="<fmt:message key="clear" bundle="${lang}"/>" /></td>
						<td colspan=3></td>
					</tr>
					
				</c:forEach>
			</table>
	</form>
	
	</td>
</tr></table></body></html>