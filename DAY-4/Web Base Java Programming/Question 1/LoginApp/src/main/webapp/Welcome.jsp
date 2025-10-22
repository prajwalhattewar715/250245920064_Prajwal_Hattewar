<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head><title>Welcome</title></head>
<body>
  <h2>Login Successful!</h2>
  <p>Welcome, <b><%= session.getAttribute("loginid") %></b></p>
  <a href="index.jsp">Logout</a>
</body>
</html>
