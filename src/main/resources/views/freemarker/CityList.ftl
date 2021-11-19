<!DOCTYPE html>
<html>
    <head>
        <title>Cities</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
 		<style>
			table {font-family: arial, sans-serif; border: solid 1px black; border-collapse: collapse}
			thead {border: 1px solid red; background-color: green; color: white; font-weight: bold; font-size: 120%}
			thead td {border: 1px solid white; text-align: left; padding: 8px}
			tr:nth-child(even) {background-color: #dddddd}
			th {border: 1px solid white; background-color: green; color: white;  padding: 8px}
			tbody td {border: 1px solid green; text-align: left; padding: 8px}
			th.left, td.left {text-align: left}
			th.center, td.center {text-align: center}
			th.right, td.right {text-align: right}
		</style>
    </head>
    <body>
        <h2>${title}</h2>

        <table class="datatable">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Population</th>
            </tr>

            <#list cities as city>
                <tr>
                    <td>${city.cityId}</td>
                    <td>${city.name}</td>
                    <td>${city.population}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>