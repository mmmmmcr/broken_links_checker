package brokenLinks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FindLinks implements FindLinkAction {
	private List<WebLinkType> elementList = new ArrayList<WebLinkType>();

	public List<WebLinkType> findAllLinks(String url) throws IOException
	// function which returns the URLs of the page as an ArrayList
	{

		Set<String> result = new LinkedHashSet<String>();

		Document downloadedHtml = Jsoup.connect(url).get();
		Elements links = downloadedHtml.select("a[href]");//select links (a href in HTML)
		Elements media = downloadedHtml.select("[src]");//select media

		// links  
		for (Element link : links) {
			result.add(link.attr("abs:href"));
		}

		// images
		for (Element src : media) {
			result.add(src.attr("abs:src"));
		}

		for (String it : result) {// iterate through set,create WebLinkType elements and add to elementList
			WebLinkType temp = new WebLinkType();
			temp.url = it;
			elementList.add(temp);
		}

		return elementList;
	}

}
