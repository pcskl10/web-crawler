package WebCrawler;


public class InvalidPageURLException extends Exception
{
	private String message;

	public InvalidPageURLException(String message) 
	{
		super(message);
		
	}

	String getMsg()
	{
		return message;
	}
}
