package WebCrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa wyszukuj¹ca linki w kodzie Ÿród³owym strony
 * @author Pawel
 *
 */
public class UrlSearch 
{
	/** Kolejka przechowuj¹ca strony do odwiedzenia */
	private Queue queue = new Queue();
	
	private ErrorsLog errorsLog = new ErrorsLog();
	private PageDownloader p = new PageDownloader();
	private OdwiedzoneStrony o = new OdwiedzoneStrony();
	private String startingPageUrl;
	
	public UrlSearch(String str)
	{
		this.startingPageUrl = str;
	}

	/**
	 * Metoda obs³uguj¹ca dodawanie i wyszukiwanie linków
	 * @throws DownloaderException
	 * @throws MalformedURLException 
	 */
	public void urlsManagement() throws InvalidPageURLException, PageIOException, MalformedURLException
	{
		URL url;
		try 
		{
			url = new URL(startingPageUrl);
			queue.addPage(url);
			while(!queue.isEmpty())
			{
				String nowyLink = queue.getNextPage().toString();
				this.searchForURLs(p.downloadPage(nowyLink));
			}
		} 
		catch (InvalidPageURLException e) 
		{
			errorsLog.zapisDoPliku(e.getMessage());
			throw new InvalidPageURLException(e.getMessage());
		}
		catch (PageIOException e) 
        {
			errorsLog.zapisDoPliku(e.getMessage());
			throw new PageIOException(e.getMessage());
        }
		
	}
	
	
	/**
	 * Metoda szukaj¹ca linków w kodzie Ÿród³owym
	 * @param str
	 * @throws InvalidPageURLException 
	 * @throws DownloaderException
	 */
	public void searchForURLs(String str) throws InvalidPageURLException 
	{
		Pattern pattern = Pattern.compile("<[Aa][\\s\\p{Punct}a-zA-Z0-9]*[Hh][Rr][Ee][Ff] *= *\"([^\"]+)");
		Matcher m = pattern.matcher(str);
		while(m.find())
		{
			String link = m.group(1);
			if((link.startsWith("http")) || (link.startsWith("https")))
			{
				URL url;
				try 
				{
					url = new URL(link);
					if(!o.pageAlreadyVisited(url) && !queue.URLsList.contains(url))
					{
						System.out.println(url.toString());
						queue.addPage(url);
					}	
				} 
				catch (MalformedURLException e) 
				{
					errorsLog.zapisDoPliku(e.getMessage());
					throw new InvalidPageURLException(e.getMessage());
				}
			}	
		}
	}
	
	public void setUrl(String str)
	{
		this.startingPageUrl = str;
	}
	
	public String getUrl()
	{
		return startingPageUrl;
		
	}
}
