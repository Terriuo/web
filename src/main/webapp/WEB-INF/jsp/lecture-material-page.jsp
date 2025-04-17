<!DOCTYPE html>
<html>
<head>
    <title>Lecture: ${lecture.title}</title>
</head>
<body>
<h1>${lecture.title}</h1>
<p><a href="${lecture.lectureNotesUrl}">Download Notes</a></p>
<h2>Additional Files</h2>
<c:if test="${fn:length(lecture.fileUrls) == 0}">
    <p>No additional files.</p>
</c:if>
<c:forEach var="fileUrl" items="${lecture.fileUrls}">
    <p><a href="${fileUrl}" download>Download File</a></p>
</c:forEach>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="/Project/lecture/${lecture.id}/upload">Upload Files</a></p>
</security:authorize>
<h2>Comments</h2>
<c:forEach var="comment" items="${comments}">
    <p>${comment.content}</p>
</c:forEach>
<security:authorize access="isAuthenticated()">
    <p><a href="/Project/lecture/${lecture.id}/comment">Add Comment</a></p>
</security:authorize>
<form action="/Project/indexpage/" method="get">
    <input type="submit" value="Back to Home" />
</form>
</body>
</html>
