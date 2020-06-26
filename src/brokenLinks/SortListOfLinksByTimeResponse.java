package brokenLinks;

import java.util.Comparator;
import java.util.List;

public class SortListOfLinksByTimeResponse implements SortOnListOfLinksAction {
	public void sortBy(List<WebLinkType> lst)
	// sort by time server response using sort method 
	{
		lst.sort(new Comparator<WebLinkType>() {
			@Override
			public int compare(WebLinkType first, WebLinkType second) {
				return (first.timeResponseServer - second.timeResponseServer);
			}

		});
	}

}
