<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form:form method="POST" modelAttribute="entry">
    <form:label path="username">UserName:</form:label>
    <form:input path="username"/><br/>

    <form:label path="password">Password:</form:label>
    <form:input path="password"/><br/>

    <form:label path="fullname">FullName:</form:label>
    <form:input path="fullname"/><br/>

    <form:label path="email">Email:</form:label>
    <form:input path="email"/><br/>

    <form:label path="phonenumber">PhoneNumber:</form:label>
    <form:input path="phonenumber"/><br/>

    <input type="hidden" name="role" value="ROLE_USER"/>

    <input type="submit" name="register" value="Confirm"/>
</form:form>
<form action="/Project/login" method="get">
    <input type="submit" value="Back" />
</form>
</body>
</html>