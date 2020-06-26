package brokenLinks;

public class WebLinkType {

	public enum status {// enum for status of an URL
		DOWN, UP;
	}

	public status statusLink = status.DOWN;// store the status of URL
	public String url = null;// store the URL
	public int timeResponseServer = Integer.MAX_VALUE;// store server response time

}
