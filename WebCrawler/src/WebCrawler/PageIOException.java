package WebCrawler;

public class PageIOException extends Exception
{
	private static final long serialVersionUID = -6291566913502697654L;
	private String message;

	public PageIOException(String msg) 
	{
		super(msg);
		this.message = msg;
		
	}
	
	public String getMsg()
	{
		return message;
	}
}
