package Testy;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import WebCrawler.OdwiedzoneStrony;

public class OdwiedzoneStronyTest {

	@Test
	public void test() 
	{
		OdwiedzoneStrony o = new OdwiedzoneStrony();
		try 
		{
			URL url = new URL("http://onet.pl");
			
			assertEquals(false, o.pageAlreadyVisited(url));
			
			o.addVisitedPage(url);
			assertEquals(true, o.pageAlreadyVisited(url));
			
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
