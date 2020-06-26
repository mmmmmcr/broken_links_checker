package brokenLinks;

import java.util.ArrayList;
import java.util.List;

import brokenLinks.WebLinkType.status;

public class FilterListOfLinksByDown implements FilterListOfLinksByAction {

	public List<WebLinkType> filterBy(List<WebLinkType> list)
	// sort Down URLs and returns a list
	{
		List<WebLinkType> justDownLinks = new ArrayList<WebLinkType>();
		for (WebLinkType it : list) {
			if (it.statusLink == status.DOWN) {
				justDownLinks.add(it);
			}
		}
		return justDownLinks;
	}

}
