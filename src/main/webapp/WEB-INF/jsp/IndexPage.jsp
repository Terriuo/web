<!DOCTYPE html>
<html>
<head>
  <title>Index Page</title>
</head>
<body>
<!--Login Statu-->
<security:authorize access="isAuthenticated()">
  <c:url var="logoutUrl" value="/logout"/>
  <form action="${logoutUrl}" method="post">
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form>
  <p>Hello <security:authentication property="principal.username" />!</p>
</security:authorize>

<!--Guest Statu-->
<security:authorize access="!isAuthenticated()">
  <form action="/Project/login" method="get">
    <input type="submit" value="login" />
  </form>
  <p>Hello Guest</p>
</security:authorize>

<p>Lecture List: </p>

<p>Chat Board</p>
<c:if test="${fn:length(entries) == 0}">
  <p>There is no message yet.</p>
</c:if>

<c:if test="${fn:length(entries) > 0}">
  <ul>
    <c:forEach var="entry" items="${entries}">
      <li>
        #${entry.id} - ${entry.name} (<fmt:formatDate value="${entry.date}" pattern="yyyy-MM-dd"/>):
        <security:authorize access="hasRole('ROLE_ADMIN')">
        <c:url value="/indexpage/edit/${entry.id}" var="myURL"/>
        [<a href="${myURL}">Edit</a>]
        <c:url value="/indexpage/delete/${entry.id}" var="myURL"/>
        [<a href="${myURL}">Delete</a>]
        </security:authorize>
        <br/>
        <c:out value="${entry.message}" escapeXml="true"/><br/>
      </li>
    </c:forEach>
  </ul>
</c:if>
<security:authorize access="isAuthenticated()">
  <p><a href="<c:url value="/indexpage/add" />">Add Comment</a></p>
  <p><a href="/Project/user/voting-history">View Voting History</a></p>
  <p><a href="/Project/user/comment-history">View Comment History</a></p>
</security:authorize>
</body>
</html>
