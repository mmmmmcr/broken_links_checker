package brokenLinks;

import java.io.IOException;

import java.util.List;

public interface FindLinkAction {
	public List<WebLinkType> findAllLinks(String webUrl)throws IOException;
	
	//add function in case you want to extend
}
