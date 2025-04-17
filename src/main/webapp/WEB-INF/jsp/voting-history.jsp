<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Voting History</title>
</head>
<body>
<h1>Your Voting History</h1>
<c:if test="${fn:length(votes) == 0}">
    <p>You haven't voted yet.</p>
</c:if>
<c:if test="${fn:length(votes) > 0}">
    <ul>
        <c:forEach var="vote" items="${votes}">
            <li>
                Poll: ${vote.pollOption.poll.question} - Option: ${vote.pollOption.optionText}
            </li>
        </c:forEach>
    </ul>
</c:if>
<form action="/Project/indexpage/" method="get">
    <input type="submit" value="Back to Home" />
</form>
</body>
</html>
