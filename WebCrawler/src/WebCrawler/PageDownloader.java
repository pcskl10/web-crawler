package WebCrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageDownloader implements WWWPageDownloader 
{

	/**
     * Pobiera wskazana strone z internetu i zwraca jej zawartosc jako napis.
     * @param pageURL adres URL strony do pobrania
     * @return napis zawierajacy zawrtosc strony (w html'u)
     * @throws DownloaderException zglaszany w sytuacji 
     *         gdy strona nie moze byc pobrana (np. nie ma srony o takim
     *         adresie, wystapil blad I/O podczas pobierania itp.)
     *
     */
	public String downloadPage(String pageURL) throws InvalidPageURLException, PageIOException
	{
		String zrodlo = "";
        try 
        {
        	System.out.println(pageURL.toString());
            URL my_url = new URL(pageURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
            String strTemp = "";
            while(null != (strTemp = br.readLine()))
            {
            	zrodlo += strTemp + "\n";
            }
            return zrodlo;  
        } 
        catch (IOException e) 
        {
        	throw new PageIOException(e.getMessage());
        }
	}
}
