package brokenLinks;

import java.net.URL;

public interface LinkTypeAction {
	public void isLinkBroken(URL url,WebLinkType element) throws Exception;

	public int responseTimeServer();

	// add function in case you want to extend
}
