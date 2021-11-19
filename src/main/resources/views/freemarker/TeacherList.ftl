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
                <th>Titel</th>
            	<th>Vorname</th>
            	<th>Nachname</th>
            </tr>

            <#list teachers as teacher>
                <tr>
                    <td>${teacher.teacherId}</td>
                    <td>${(teacher.title)!}</td>
                    <td>${teacher.firstname}</td>
                    <td>${teacher.surname}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>