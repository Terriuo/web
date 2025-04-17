<!DOCTYPE html>
<html>
<head>
    <title>Upload Course Materials</title>
</head>
<body>
<h1>Upload Files for Lecture</h1>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <form method="POST" enctype="multipart/form-data">
        <input type="file" name="files" multiple /><br/>
        <input type="submit" value="Upload" />
    </form>
</security:authorize>
<form action="/Project/lecture/${lectureId}" method="get">
    <input type="submit" value="Back to Lecture" />
</form>
</body>
</html>
