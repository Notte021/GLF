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
            	<th>#</th>
                <th>Id</th>
                <th>Name</th>
                <th>KV/JV</th>
                <th>Students</th>
            </tr>

            <#list schoolClasses as schoolClass>
                <tr>
                	<td>${schoolClass?counter}</td>
                    <td>${schoolClass.schoolClassId}</td>
                    <td>${schoolClass.name}</td>
                    <td>${schoolClass.getTeacher()}</td>
                    <td><a href="/students/showStudents?schoolClassId=${schoolClass.schoolClassId}" target="_blank">Show students</a></td>
                </tr>
            </#list>
        </table>
    </body>
</html>