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
                <th>Name</th>
                <th>Name kurz</th>
            </tr>

            <#list subjects as subject>
                <tr>
                    <td>${subject.subjectId}</td>
                    <td>${subject.name}</td>
                    <td>${subject.nameShort}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>