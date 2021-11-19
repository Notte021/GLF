package at.htlklu.spring.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value ="")
public class FirstController
{
	@GetMapping(value = "firstwebservice.html")
	@ResponseBody
	public String firstwebservice()
	{
		// test
		return  "<html>\n" +
				"  <head>\n" +
				"    <title>Testseite</title>\n" +
				"  </head>\n" +
				"  <body>\n" +
				"    <h1>Mein erstes WebService (" + LocalDateTime.now() + ")</h1>\n" +
				"  </body>\n" +
				"</html>";
	}

}
