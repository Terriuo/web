<!DOCTYPE html>
<html>
<head>
    <title>Poll: ${poll.question}</title>
</head>
<body>
<h1>${poll.question}</h1>
<form method="POST" action="/Project/vote">
    <input type="hidden" name="pollId" value="${poll.id}"/>
    <c:forEach var="option" items="${options}">
        <input type="radio" name="selectedOptionId" value="${option.id}"/>
        ${option.optionText} (${option.voteCount} votes)<br/>
    </c:forEach>
    <security:authorize access="isAuthenticated()">
        <input type="submit" value="Vote"/>
    </security:authorize>
</form>
<h2>Comments</h2>
<c:forEach var="comment" items="${comments}">
    <p>${comment.content}</p>
</c:forEach>
<security:authorize access="isAuthenticated()">
    <p><a href="/Project/poll/${poll.id}/comment">Add Comment</a></p>
</security:authorize>
<form action="/Project/indexpage/" method="get">
    <input type="submit" value="Back to Home" />
</form>
</body>
</html>
