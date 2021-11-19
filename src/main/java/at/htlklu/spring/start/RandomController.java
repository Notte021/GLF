package at.htlklu.spring.start;

import at.htlklu.spring.api.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping(value = "/random")
public class RandomController
{
	private static final Logger logger = LogManager.getLogger(RandomController.class);
	private static final String className = "RandomController";
	private static final Random rNG = new Random();


	//region Get
	@GetMapping(value = "/nextIntGet")
	@ResponseBody
	public int nextIntGet()
	{
		logger.info(LogUtils.info(className, "nextIntGet"));
		return rNG.nextInt();
	}

	@GetMapping(value = "/nextIntGetPV/{min}/{max}")
	@ResponseBody
	public int nextIntGetPV(@PathVariable Integer min,
					        @PathVariable Integer max)
	{
		logger.info(LogUtils.info(className, "nextIntGetPV", String.format("(%d, %d)", min, max)));
		return rNG.nextInt(max - min + 1) + min;
	}

	@GetMapping(value = "/nextIntGetRP")
	@ResponseBody
	public int nextIntGetRP(@RequestParam Integer min,
					        @RequestParam Integer max)
	{
		logger.info(LogUtils.info(className, "nextIntGetRP", String.format("(%d, %d)", min, max)));
		return rNG.nextInt(max - min + 1) + min;
	}

	@GetMapping(value = "/nextIntGetRPOpt")
	@ResponseBody
	public int nextIntGetRPOpt(@RequestParam Optional<Integer> optMin,
						       @RequestParam Optional<Integer> optMax)
	{
		int min = optMin.orElse(100);
		int max = optMax.orElse(200);
		logger.info(LogUtils.info(className, "nextIntGetRPOpt", String.format("(%d, %d)", min, max)));
		return rNG.nextInt(max - min + 1) + min;
	}
	//endregion


	//region Post
	@PostMapping(value = "/nextIntPostRP")
	@ResponseBody
	public int nextIntPostRP(@RequestParam Integer min,
						     @RequestParam Integer max)
	{
		logger.info(LogUtils.info(className, "nextIntPostRP", String.format("(%d, %d)", min, max)));
		return rNG.nextInt(max - min + 1) + min;
	}
	//endregion

}
