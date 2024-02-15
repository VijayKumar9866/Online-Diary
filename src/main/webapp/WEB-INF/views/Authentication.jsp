
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="p" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Diary</title>
<link rel="icon" href='<c:url value="/resources/images/logo.jpg"></c:url>' type="image/jpg">

<link rel="stylesheet" href='<c:url value="/resources/css/Authentication.css"></c:url>'>
</head>
<body>
	<div id="header">
		<img src='<c:url value="/resources/images/logo.jpg"></c:url>'>
		<header id="mydiary">My Diary</header>
	</div>
	<hr>
	<div id="nav">
		<h3>Welcome </h3>
		<h3 id="username">${user.username}</h3>
		<a href="./logout" id="logout">Logout</a>
	</div>
	<div id="top">
		<h4>Last Entries</h4>
		<button type="button" id="addentry"><a href="./Addentry">Add Entry</a></button>
	</div>
	<div id="table">
	<table>
		<tr>
			<th>Date</th>
			<th colspan="3">Description</th>
		<tr>
		<c:if test="${entrieslist.size()==0}">
		<tr>
			<td colspan="4" style="font-size: 25px; text-align: center;" >There is no previous data</td>
		</tr>
		</c:if>
		<c:forEach items="${entrieslist}" var="v">
			
			<tr>
			
				<td><p:formatDate value="${v.date}" pattern="dd/MM/yyyy"/></td>
				<td><a href="./viewpage?id=${v.id}">view</a></td>
				<td><a href="./updatecontent?id=${v.id}">update</a></td>
				<td><a href="./delete?id=${v.id}">delete</a></td>
			<tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>