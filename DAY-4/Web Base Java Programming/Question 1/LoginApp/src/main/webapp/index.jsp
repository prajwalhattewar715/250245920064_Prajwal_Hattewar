<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
</head>
<body>
  <h2>Login</h2>
  <form action="LoginServlet" method="post">
    <label>Login ID:</label>
    <input type="text" name="loginid" required /><br/><br/>
    <label>Password:</label>
    <input type="password" name="password" required /><br/><br/>
    <input type="submit" value="Login" />
  </form>
</body>
</html>
