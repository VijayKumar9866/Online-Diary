<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Diary</title>
<link rel="stylesheet" href='<c:url value="/resources/css/updatecontent.css"></c:url>'>
<link rel="icon" href='<c:url value="/resources/images/logo.jpg"></c:url>' type="image/jpg">

</head>
<body>
<div id="header">
		<img src='<c:url value="/resources/images/logo.jpg"></c:url>'>
		<header id="mydiary">My Diary</header>
	</div>
	<hr>
	<h3>${user.username}</h3>
	<h2>update your Story</h2>
	<div id="form">
	<form action="./updateentry" method="post">
	
		<label for="date" class="date">Date:</label>
		<input type="text" name="date1" class="date" id="date" value='<fmt:formatDate value="${entry.date}" pattern="dd-MM-yyyy"/>' readonly><br><br>
		<label for="description" class="content">Description:</label>
		<textarea rows="30" cols="100"  name="content" id="content">${entry.content}</textarea><br>
		<input type="submit" value="Update" id="add">
		<input type="hidden" name="userid" value="${entry.userid}">
		<input type="hidden" name="id" value="${entry.id}">
		<input type="hidden" name="date" value="${entry.date}">
	</form>
	</div>
</body>
</html>