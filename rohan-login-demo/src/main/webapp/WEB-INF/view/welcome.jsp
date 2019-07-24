<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Welcome - Spring Demo App</title>
	</head>
	
	<body>
		<h1>Welcome</h1>
		<hr>
		<h2>Spring Security Demo - Rohan Negi</h2>
		<p>
			Hello, <security:authentication property="principal.username"/>. 
			<br>
			Your authorities: <security:authentication property="principal.authorities"/>
		</p>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout"/>
		</form:form>
		
	</body>
</html>	