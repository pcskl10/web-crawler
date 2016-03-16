package Testy;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import WebCrawler.ErrorsLog;

public class ZapisBledowTest 
{

	@SuppressWarnings("resource")
	@Test
	public void test() 
	{
		ErrorsLog zapis = new ErrorsLog();
		
		zapis.zapisDoPliku("abcd");
		
		String s = "";
		try 
		{
			FileReader wejscie = new FileReader(zapis.config.errorLogFilePrefix + zapis.config.dzisiajeszaData() + ".txt");
			int c;
			StringBuilder sb = new StringBuilder("");
            while((c = wejscie.read()) != -1) 
            {
                sb.append((char) c);
            }
            s = sb.toString();
            
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println(s);
		
		assertEquals(true, s.endsWith("abcd\n")); // metoda automatycznie dodaje "\n"
		
		
		
	}	

}

