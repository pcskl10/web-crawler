package WebCrawler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class WebCrawlerConfig 
{
	public String errorLogFilePrefix = "error_log_";
	private DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
	
	/** Okres czasu po jakim ma byc wypisywana wydajnosc crawlera **/
	static int okres_czasu = 10;
	
	public String dzisiajeszaData()
	{
		Date today = Calendar.getInstance().getTime();        		
		String reportDate = dateFormat.format(today);
		return reportDate;
	}
	
	void setFilePrefix(String prefix)
	{
		this.errorLogFilePrefix = prefix;
	}
	
	String getFilePrefix()
	{
		return this.errorLogFilePrefix;
	}
	
	void setdateFormat(DateFormat df)
	{
		this.dateFormat = df;
	}

	DateFormat getDateFormat()
	{
		return this.dateFormat;
	}

}