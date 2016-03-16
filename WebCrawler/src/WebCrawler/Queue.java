package WebCrawler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * Kolejka FIFO zawierajaca adresy stron, ktore maja zostac pobrane (odwiedzone).
 */
public class Queue implements DownloadQueue 
{
	/** Kolejka przechowuj¹ca adresu URL */
	List<URL> URLsList = new ArrayList<URL>();
	String urlToDelete;

	/**
     * Dodaje adres strony do odwiedzenia na koniec kolejki
     *
     * @param pageURL adres strony do odwiedzenia
     */
	public void addPage(URL pageURL) 
	{
		URLsList.add(pageURL);
	}

	/**
     * Zwraca informacje czy kolejka jest pusta, czy nie
     * @return true - kolejka pusta, false - w przeciwnym razie
     */
	public boolean isEmpty() 
	{
		return URLsList.isEmpty();
	}

	/**
     * Zwraca adres pierwszej strony w kolejce, ktora ma zostac odwiedzona i
     * usuwa ja z kolejki.
     * 
     * @return adres URL strony do odwiedzenia
     */ 
	public URL getNextPage() 
	{
		URL returned;
		returned = URLsList.get(0);
		this.urlToDelete = returned.toString();
		OdwiedzoneStrony.fifoOdwiedzone.add(returned);
		URLsList.remove(0);
		return returned;
	}

}
