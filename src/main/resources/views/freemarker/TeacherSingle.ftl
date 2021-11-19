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

		<#if teacher?? >
	        <form action="/teachers" method="POST" enctype="application/x-www-form-urlencoded">
	        	teacherId: <@spring.formInput "teacher.teacherId"/>
                		   <@spring.showErrors "<br>"/> <br>
          	    Titel:     <@spring.formInput "teacher.title"/>
                		   <@spring.showErrors "<br>"/> <br>
	        	Firstname: <@spring.formInput "teacher.firstname"/>
                		   <@spring.showErrors "<br>"/> <br>
	        	Surname:   <@spring.formInput "teacher.surname"/>
                		   <@spring.showErrors "<br>"/> <br>
                <input type="submit" value="Submit" />
                		                  
	    	<!--
	    		<input type="text" name="teacherId" value=${teacher.teacherId} size="10"/><br>
	    		<input type="text" name="title" value=${teacher.title} size="30"/><br>
	    		<input type="text" name="firstname" value=${teacher.firstname} size="30"/><br>
	    		<input type="text" name="surname" value=${teacher.surname} size="100"/><br>
	    		<input type="submit" value="Submit" />
	    	-->	
			</form> 
			<br><br><br>
			
            Name: ${teacher.surname}<br>
            Message: ${teacher.firstname}<br>
        <#else>
        	Kein Lehrer
		</#if>

    </body>
</html>