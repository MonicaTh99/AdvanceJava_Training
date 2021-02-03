<%@include file="header.jsp" %>
<%@ page isELIgnored="false" %>

<h1>Add user</h1>
<form action="<%=request.getContextPath()%>/UserController/edit-user" method="post">
	Userid : <input type="text" name="id" value="${user.id}" readonly="readonly" >
	<br>
	Username: <input type="text" name="username" value="${user.name}">
 	<br>
	Password: <input type="password" name="password" value="${user.password}">
	<br>
	Address: <input type="text" name="address" value="${user.address}">
	<br>
	<input type="submit" value="Update user">
</form>

<%@include file="footer.jsp" %>