<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Welcome - Spring Demo App</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	
	<body>
		<h1>Welcome</h1>
		<hr><br>
		<br>
		<h2>Spring Security Demo - Rohan Negi</h2>
		<br><br>
		
		<!-- Display user-name and authorities -->
		<p>
			Hello, <security:authentication property="principal.username"/>. 
			<br><br>
			Your authorities: <security:authentication property="principal.authorities"/>
		</p>
		
		<!-- Logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" class="button redirect"/>
		</form:form>
		
	</body>
</html>	