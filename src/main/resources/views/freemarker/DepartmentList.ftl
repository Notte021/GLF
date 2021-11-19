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
                <th>Name short/th>
                <th>Head</th>
                <th>Edit</th>
                <th>SchoolClasses</th>
            </tr>

            <#list departments as department>
                <tr>
                    <td>${department.departmentId}</td>
                    <td>${department.name}</td>
                    <td>${department.nameShort}</td>
                    <td>${department.getTeacher()}</td>
                    <td><a href="/departmentShow/showDepartment/${department.departmentId}" target="_blank">Edit department</a></td>
                    <td><a href="/schoolClasses/showSchoolClasses?departmentId=${department.departmentId}" target="_blank">Show classes</a></td>
                </tr>
            </#list>
        </table>
    </body>
</html>