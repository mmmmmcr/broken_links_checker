package brokenLinks;

import java.util.List;

public class SortListOfLinksByName implements SortOnListOfLinksAction {

	public void sortBy(List<WebLinkType> lst)
	// sort the WebLinkType list by name
	{
		lst.sort((WebLinkType first, WebLinkType second) -> (first.url.toString())
				.compareToIgnoreCase(second.url.toString()));// sort alphabetically URLs

	}
}
