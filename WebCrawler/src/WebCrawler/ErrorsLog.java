package WebCrawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasa do wypisywania tresci bledow do pliku
 * @author Pawel
 *
 */
public class ErrorsLog
{
	/** Konfiguracja **/
	public WebCrawlerConfig config = new WebCrawlerConfig();
	
	/**
	 * Zapisuje podana tresc bledu do pliku w ktorego tytule znajduje sie prefix+dzisiejsza data
	 * @param tresc bledu
	 */
	public void zapisDoPliku(String info)
	{
		try 
		{
			FileWriter pisacz = null;
			pisacz  = new FileWriter(config.errorLogFilePrefix + config.dzisiajeszaData() + ".txt", true);
			BufferedWriter out = new BufferedWriter(pisacz);
			out.write(info);
			out.write("\n");
			out.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}