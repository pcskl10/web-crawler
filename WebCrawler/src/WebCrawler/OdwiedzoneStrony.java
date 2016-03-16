package WebCrawler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * Klasa rejestru odwiedzonych stron, 
 * ktora pozwala sprawdzic czy strona o danym adresie byla juz odwiedzana czy nie.
 */
public class OdwiedzoneStrony implements VisitedPages 
{
	/** Kolejka adresów URL, które zosta³y ju¿ odwiedzone */
	static List<URL> fifoOdwiedzone = new ArrayList<URL>();

	/**
     * Sprawdza czy dana strona byla juz odwiedzana.
     * 
     * @param pageURL adres strony do sprawdzenia
     * @return true - strona byla juz wczesniej odwiedzana, false -
     *         w przeciwnym razie
     */ 
	public boolean pageAlreadyVisited(URL pageURL) 
	{
		return fifoOdwiedzone.contains(pageURL);
	}

	/**
     * Rejestruje strone o podanym adresie jako odwiedzona.
     *
     * @param pageURL adres odwiedzonej strony
     */
	public void addVisitedPage(URL pageURL) 
	{
		fifoOdwiedzone.add(pageURL);
	}

}
