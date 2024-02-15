<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Diary</title>
<link rel="icon" href='<c:url value="/resources/images/logo.jpg"></c:url>'>
<link rel="stylesheet" href='<c:url value="/resources/css/Addentry.css"></c:url>'>
</head>
<body>
	<div id="header">
		<img src='<c:url value="/resources/images/logo.jpg"></c:url>'>
		<header id="mydiary">My Diary</header>
	</div>
	<hr>
	<h3>${user.username}</h3>
	<h2>Add your Story</h2>
	<div id="form">
	<form action="./saveentry" method="post">
	
		<label for="date" class="date">Date:</label>
		<input type="date" name="date" class="date" id="date"><br><br>
		<label for="description" class="content">Description:</label>
		<textarea rows="30" cols="100"  name="content" id="content"></textarea><br>
		<input type="submit" value="ADD" id="add">
		<input type="hidden" name="userid" value="${user.id}">
	</form>
	</div>
	
</body>
</html>