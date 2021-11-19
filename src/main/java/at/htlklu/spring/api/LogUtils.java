package at.htlklu.spring.api;

public class LogUtils
{	
	public static String info(String className,
							  String methodName,
							  String parameters)
	{
		return String.format("HTL -> %s -> %s -> %s", className, methodName, parameters);
	}

	public static String info(String className,
							  String methodName)
	{
		return LogUtils.info(className, methodName, "");
	}
}
