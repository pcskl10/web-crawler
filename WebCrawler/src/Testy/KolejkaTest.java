package Testy;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import WebCrawler.Queue;

public class KolejkaTest {

	@Test
	public void test() 
	{
		Queue kolejka = new Queue();
		try 
		{
			URL url = new URL("http://onet.pl");
			
			assertEquals(true, kolejka.isEmpty());
			
			kolejka.addPage(url);
			assertEquals(false, kolejka.isEmpty());
			
			assertEquals(url, kolejka.getNextPage()); // Test pobierania pierwszego adresu z kolejki
			
			assertEquals(true, kolejka.isEmpty()); // Test usuwania z kolejki pobranego ju¿ adresu
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
