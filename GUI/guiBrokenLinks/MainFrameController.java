package guiBrokenLinks;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import brokenLinks.FilterListOfLinksByAction;
import brokenLinks.FilterListOfLinksByDown;
import brokenLinks.FindLinkAction;
import brokenLinks.FindLinks;
import brokenLinks.LinkTypeAction;
import brokenLinks.LinkTypeBrokenCheck;
import brokenLinks.SortListOfLinksByName;
import brokenLinks.SortListOfLinksByTimeResponse;
import brokenLinks.SortOnListOfLinksAction;
import brokenLinks.WebLinkType;

@SuppressWarnings("serial")
public class MainFrameController extends JFrame {
	private List<WebLinkType> allLinks;
	private TextPanels textArea;
	private OptionBar options;
	private JButton clickToCheckButton;
	private FindLinkAction search;
	private String url;
	private LinkTypeAction isBroken;
	private ThreadForMainTask newThread;

	public MainFrameController()
	// constructor
	{

		super("Broken Links Checker by Badoi Mircea");// constructor of JFrame

		textArea = new TextPanels();

		setLayout(new BorderLayout());

		options = new OptionBar();

		options.setOptionBar(textArea);

		options.getClass(this);

		clickToCheckButton = new JButton("Click to check URL");

		textArea.addToScreen(
				"WARNING :PRESS  Click to check URL  AND WAIT FOR THE RESULTS(UNTIL FINISHED IT IS DISPLAYED) \n YOU MAY NOT PRESS ANY BUTTON UNTIL FINISHED FOR CORRECT RESULTS \n");

		newThread = new ThreadForMainTask();
		newThread.getClass(this);

		clickToCheckButton.addActionListener(new ActionListener()
		// action when you click the button
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.clear();
					url = textArea.getUrlFromField();
					Thread myThread = new Thread(newThread);// new thread
					myThread.start();

				} catch (Exception e1) {

					textArea.addToScreen("ERROR....TRY AGAIN(you may check the URL)");

				}

			}

		});

		// set the location of elements in BorderLayout
		add(options, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(clickToCheckButton, BorderLayout.SOUTH);
		setVisible(true);// make the frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// stop run of application when you press exit
		setSize(900, 600);// size of the up when started

	}

	public void run() throws Exception
	// run the app(set conditions)
	{
	
		try {
			
			search = new FindLinks();
			allLinks = search.findAllLinks(url);// find the URLs on page

			for (WebLinkType element : allLinks) {// iterate through the list of URLs and check if they are broken or
													// not

				isBroken = new LinkTypeBrokenCheck();

				isBroken.isLinkBroken(new URL(element.url), element);// status of an URL

				element.timeResponseServer = isBroken.responseTimeServer();// time response server

				textArea.addToScreen(
						element.url + "  " + element.statusLink + " " + element.timeResponseServer + " ms\n");

				System.out.println("URL: " + element.url + "  " + element.timeResponseServer + " ms" + " status URL: "
						+ element.statusLink);

			}
		

		catch (Exception e)

		{
			// error in case of a bad URL

			textArea.addToScreen("ERROR....TRY AGAIN");
			System.out.println(" Exception occured -&gt; " + e.getMessage());

		}

		finally {
			textArea.addToScreen(" \nFINISHED ");// let the user know when operation completed
		}
		}

	}

	

	public void runSortByName()
	// set the SortByName conditions,run it and add results to textArea
	{
		try {
			SortOnListOfLinksAction temp = new SortListOfLinksByName();
			temp.sortBy(allLinks);

			for (WebLinkType it : allLinks) {
				textArea.addToScreen(it.url + " " + it.statusLink + " " + it.timeResponseServer + " ms\n");
			}
		} catch (Exception notCheckedFirst) {
			urlNotChecked();
		}

	}

	public void runSortByTimeResponseServer()
	// set the SortByTimeResponseServer conditions,run it and add results to
	// textArea
	{
		SortOnListOfLinksAction temp = new SortListOfLinksByTimeResponse();
		try {
			temp.sortBy(allLinks);

			for (WebLinkType it : allLinks) {
				textArea.addToScreen(it.url + " " + it.timeResponseServer + " ms" + "\n");
			}
		} catch (Exception notCheckedFirst) {
			urlNotChecked();
		}

	}

	public void runfilterByLinkByDown()
	//// set the filterByLinkByDown conditions,run it and add results to textArea
	{
		FilterListOfLinksByAction temp = new FilterListOfLinksByDown();
		try {
			List<WebLinkType> filtered = temp.filterBy(allLinks);
			if (filtered.isEmpty()) {
				textArea.addToScreen("NO BROKEN LINKS\n");
			} else {
				for (WebLinkType it : filtered) {
					textArea.addToScreen(it.url + "\n");
				}
			}
		} catch (Exception notCheckedFirst) {
			urlNotChecked();
		}
	}

	public void urlNotChecked() {
		textArea.addToScreen("First you need to check an URL");
	}

}
