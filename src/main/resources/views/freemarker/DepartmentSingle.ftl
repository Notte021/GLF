<#import "/spring.ftl" as spring />

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

		<#if department?? >
	        <form action="/departments" method="POST" enctype="application/x-www-form-urlencoded">
	        	departmentId: <@spring.formInput "department.departmentId"/>
                		      <@spring.showErrors "<br>"/> <br>
          	    Name:         <@spring.formInput "department.name"/>
                		      <@spring.showErrors "<br>"/> <br>
	        	Name short:   <@spring.formInput "department.nameShort"/>
                		      <@spring.showErrors "<br>"/> <br>
                		      
<!--
	        	teacherId:    <@spring.formInput "department.teacherId"/>
                		      <@spring.showErrors "<br>"/> <br>
-->

                Teacher:      <select id="inputGroupSelect06">
						         <#list teachers as teacher>
								  	<#if department.teacherId == teacher.teacherId>
								  		<option value="${teacher.teacherId}" selected>
								  			${teacher.toString()}
								  		</option>
								  	<#else>
								  		<option value="${teacher.teacherId}">
								  			${teacher.toString()}
								  		</option>
								  	</#if>
								 </#list>
							  </select> <br>			  
                <input type="submit" value="Submit" />
			</form> 
			<br><br><br>
        <#else>
        	Keine Abteilung
		</#if>

    </body>
</html>