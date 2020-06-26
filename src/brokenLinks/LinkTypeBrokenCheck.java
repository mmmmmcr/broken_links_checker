package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;

import brokenLinks.WebLinkType.status;

public class LinkTypeBrokenCheck implements LinkTypeAction {
	// strtTime and endTime are variables to calculate the response of server
	private long startTime = 0;
	private long endTime = 0;

	public int responseTimeServer()
	// return response of server
	{
		return (int) (endTime - startTime);
	}

	public void isLinkBroken(URL url, WebLinkType element) throws Exception
	// check the server for a response
	{

		String response = "";

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try

		{
			connection.setRequestMethod("HEAD");// takes just the head
			connection.connect();// connect to the server
			startTime = System.currentTimeMillis();// measure time before
			response = connection.getResponseMessage();// acknowledge the response from the server
			endTime = System.currentTimeMillis();// measure time after
			connection.disconnect();// disconnect from the server
			if (response.equals("OK") || response.equals(String.valueOf(200))) {// we should trust only the URLs which
																					// return OK and 200 because the
																					// broken links
																					// redirects us usually
				element.statusLink = status.UP;
			} else {

				element.statusLink = status.DOWN;
			}

		}

		catch (Exception e)

		{
			// error in case it fails
			System.out.println("Problem in LinkTypeBrokenCheck(wrong link)");

		}

	}

}
