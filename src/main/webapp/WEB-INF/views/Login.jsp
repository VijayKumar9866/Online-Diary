
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My diary</title>

<link rel="stylesheet" href='<c:url value="/resources/css/Register.css"></c:url>'>

<link rel="icon" href='<c:url value="/resources/images/logo.jpg"></c:url>' type="image/jpg">
</head>
<body>
	<div id="header">
		<img src='<c:url value="/resources/images/logo.jpg"></c:url>'>
		<header id="mydiary">My Diary</header>
	</div>
	<hr>
	<div id="main">
		<div id="loginform">
			<form method="post" action="./Authentication">
				<header id="login">LOGIN</header>
				<label for="username">UserName:</label>
				<input type="text" name="username" id="username" placeholder="username"><br><br>
				<label for="password">Password:</label>
				<input type="password" name="password" id="password" placeholder="password"><br><br>
				<input type="submit" id="submit" value="Login"><br><br>
				<a href="./RegisterPage" id="new">New User,Register.</a>
			</form>
		</div>
	</div>
</body>
