<!DOCTYPE html>
<html>
<head>
    <title>Comment History</title>
</head>
<body>
<h1>Your Comment History</h1>
<c:if test="${fn:length(comments) == 0}">
    <p>You haven't posted any comments yet.</p>
</c:if>
<c:if test="${fn:length(comments) > 0}">
    <ul>
        <c:forEach var="comment" items="${comments}">
            <li>
                <c:if test="${not empty comment.lecture}">
                    Lecture: ${comment.lecture.title} -
                </c:if>
                <c:if test="${not empty comment.poll}">
                    Poll: ${comment.poll.question} -
                </c:if>
                Comment: ${comment.content}
            </li>
        </c:forEach>
    </ul>
</c:if>
<form action="/Project/indexpage/" method="get">
    <input type="submit" value="Back to Home" />
</form>
</body>
</html>
