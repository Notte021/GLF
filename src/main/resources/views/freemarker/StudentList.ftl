<!DOCTYPE html>
<html>
    <head>
        <title>Cities</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
 		<link href="/css/style.css" rel="stylesheet">
    </head>
    <body>
        <h2>${title}</h2>

        <table class="datatable">
            <tr>
                <th>Id</th>
                <th>Nachname</th>
                <th>Vorname</th>
                <th>Noten</th>
            </tr>

            <#list students as student>
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.surname}</td>
                    <td>${student.firstname}</td>
                    <td><a href="/studentSubjects/showStudentSubjects?studentId=${student.studentId}" target="_blank">Show grades</a></td>
                </tr>
            </#list>
        </table>
    </body>
</html>