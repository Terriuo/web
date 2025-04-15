<!DOCTYPE html>
<html>
<head>
    <title>Guest Book</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="POST">
    User: <input type="text" name="username"><br />
    Password: <input type="password" name="password" /><br />
    Remember Me: <input type="checkbox" name="remember-me" /><br />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input name="submit" type="submit" value="Log In" /><br />
</form>
<form action="/Project/login/register" method="get">
    <input type="submit" value="sign up" />
</form>
<form action="/Project/indexpage/" method="get">
    <input type="submit" value="Home Page" />
</form>
</body>
</html>