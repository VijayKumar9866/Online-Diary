<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Diary</title>
<link rel="stylesheet" href='<c:url value="/resources/css/viewpage.css"></c:url>'>
</head>
<body>

	<div id="header">
		<img src='<c:url value="/resources/images/logo.jpg"></c:url>'>
		<header id="mydiary">My Diary</header>
	</div>
	<hr>
	<h3>${user.username}</h3>
	<div id="date">
		<h4>Date : </h4>
		<h4><fmt:formatDate value="${entry.date}" pattern="dd/MM/yyyy"></fmt:formatDate></h4>
	</div>
	
	<div>
		<h4>Content : </h4>
		<h4 id="content">${entry.content}</h4>
	</div>
	<a href="./userpage"><input type="button" value="Home Page" id="button"></a>

</body>
</html>