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
                <th>Gegenstand</th>
                <th>Note</th>
            </tr>

            <#list studentSubjects as studentSubject>
                <tr>
                    <td>${studentSubject.studentSubjectId}</td>
                    <td>${studentSubject.getSubject()}</td>
                    <td>${studentSubject.grade}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>