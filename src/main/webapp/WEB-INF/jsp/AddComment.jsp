<!DOCTYPE html>
<html>
<head>
    <title>Add Comment</title>
</head>
<body>
<h1>Add Comment</h1>
<form:form method="POST" modelAttribute="comment">
    <form:label path="content">Comment:</form:label>
    <form:textarea path="content"/><br/>
    <input type="submit" value="Post Comment"/>
</form:form>
<form action="/Project/indexpage/" method="get">
    <input type="submit" value="Back" />
</form>
</body>
</html>
