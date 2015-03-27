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
		<h1>catalog.jsp</h1>
	</td>
</tr>
<tr>
	<td align="left" width="20%">
	<c:if test="${not empty user}">
		<fmt:message key="welcome" bundle="${lang}"/>:	${user}
		<a href="controller?command=logout"><fmt:message key="logout" bundle="${lang}"/></a>
	</c:if>	
			
	</td>
	<td align="center" width="27%">
	<form name="form" method="post" action="controller">
		<input type="hidden" name="command" value="catalog"/>
		<fmt:message key="model" bundle="${lang}"/>:
		<input type="text" name="searchParamName" size="10"/>
		<input type="submit" value="<fmt:message key="search" bundle="${lang}"/>"/>
	</form>
	</td>
	<td align="center" width="25%">
	<form name="form" method="post" action="controller">
		<input type="hidden" name="command" value="catalog"/>
		<fmt:message key="description" bundle="${lang}"/>:
		<input type="text" name="searchParamDesc" size="10"/>
		<input type="submit" value="<fmt:message key="search" bundle="${lang}"/>"/>
	</form>
	</td>
	<td align="center">
		<fmt:message key="entry" bundle="${lang}"/>
		<fmt:message key="${role}" bundle="${lang}"/>
	</td>
	<td align="right">
		<fmt:message key="language" bundle="${lang}"/>:&nbsp;
		<a href="controller?page=catalog&amp;locale=en">En</a>&nbsp;
		<a href="controller?page=catalog&amp;locale=ru">Ru</a>
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
	<h2><fmt:message key="catalog" bundle="${lang}"/></h2>
			<table>
				<tr>
					<th width="30" align="left">#</th>
					<th width="120" align="left"><fmt:message key="type" bundle="${lang}"/></th>
					<th width="100" align="left"><fmt:message key="brand" bundle="${lang}"/></th>
					<th width="180" align="left"><fmt:message key="model" bundle="${lang}"/></th>
					<th width="120" align="left"><fmt:message key="cost" bundle="${lang}"/></th>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="products" items="${products}">
					<tr height="35">
						<td>${products.getId()}</td>
						<td>${products.getType().getTypeName()}</td>
						<td>${products.getBrand().getBrandName()}</td>
						<td>${products.getName()}</td>
						<td>${products.getCost()}&nbsp;$</td>
						<td width="100">
	 <c:if test="${desc == null}"><a href="controller?command=description&idProduct=<c:out value="${products.getId()}"/>">
						<fmt:message key="description" bundle="${lang}"/></a></c:if>
						</td>
						<td width="100"><a href="controller?command=catalog&addCart=<c:out value="${products.getId()}"/>">
					<fmt:message key="toCart" bundle="${lang}"/></a></td>	
					</tr>
 <c:if test="${desc != null}"><tr><td colspan=6>${products.getDescription()}</td></tr></c:if>	
				</c:forEach>
			</table>
	
	
	</td>
</tr></table></body></html>