package Testy;

import static org.junit.Assert.*;

import org.junit.Test;

import WebCrawler.UrlSearch;

public class WyszukiwanieLinkowTest {

	@Test
	public void test() 
	{
		
		UrlSearch w = new UrlSearch("aaa");
		
		assertEquals("aaa", w.getUrl());

	}
}
