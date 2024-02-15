<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Diary</title>
<link rel="stylesheet" href='<c:url value="/resources/css/LoginIncorrect.css"></c:url>'/>
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
			<form method="post">
				<header id="login"><u>LOGIN</u></header>
				<label for="username">UserName:</label>
				<input type="text" name="username" id="username" placeholder="username"><br><br>
				<label for="password">Password:</label>
				<input type="password" name="password" id="password" placeholder="password"><br><br>
				<marquee><h5>Invalid Details</h5></marquee>
				<input type="submit" id="submit" value="Login"><br><br>
				<a href="./RegisterPage" id="new">New User,Register.</a>
			</form>
		</div>
	</div>
</body>
</html>