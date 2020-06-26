package brokenLinks;

import java.util.List;

public interface FilterListOfLinksByAction {
	public List<WebLinkType> filterBy(List<WebLinkType> lst);
	
	//add function in case you want to extend

}