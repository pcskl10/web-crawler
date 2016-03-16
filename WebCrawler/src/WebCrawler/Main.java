package WebCrawler;

import java.net.MalformedURLException;



public class Main 
{

	public static void main(String[] args) throws InvalidPageURLException, PageIOException  
	{
		
		UrlSearch searchForLinks = new UrlSearch("http://agh.edu.pl/");
		
		while(true)
		{
			try 
			{
				searchForLinks.urlsManagement();
			} 
			catch (MalformedURLException e) 
			{
				e.printStackTrace();
			}
		}
			
		
		
	}
}
