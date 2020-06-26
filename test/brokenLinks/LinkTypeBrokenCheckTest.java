package brokenLinks;

import static org.junit.Assert.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class LinkTypeBrokenCheckTest {
	private LinkTypeAction test;
	private ArrayList<String> expectedResponsFromServer = new ArrayList<String>();;
	private ArrayList<String> actualResponsFromServer;
	private ArrayList<String> inputLinksToCheck = new ArrayList<String>();;

	// constructor in order to use automate tests
	public LinkTypeBrokenCheckTest(ArrayList<String> expectedResponsFromServer, ArrayList<String> inputLinksToCheck) {
		super();
		this.expectedResponsFromServer = expectedResponsFromServer;
		this.inputLinksToCheck = inputLinksToCheck;

	}

	@Before
	// initialise the needed variables before every test
	public void init() {
		test = new LinkTypeBrokenCheck();
		actualResponsFromServer = new ArrayList<String>();
	}

	@Parameters
	// parameters(input and output)for automate tests
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { new ArrayList<String>() {
			{ // expected output
				add("UP");
				add("UP");
				add("UP");
			}
		}, new ArrayList<String>() {
			{ // input
				add("https://www.tutorialspoint.com/junit/junit_parameterized_test.htm");
				add("https://www.4tuning.ro/");
				add("https://www.realitatea.net/");
			}
		} }, { new ArrayList<String>() {
			{ // expected output
				add("DOWN");

			}
		}, new ArrayList<String>() {
			{ // input
				add("https://www.ralitatea.net/");// link is broken

			}
		} },

		});
	}

	@Test
	public void testBrokenLinkChecker() throws Exception {
		for (String it : inputLinksToCheck) {
			WebLinkType element = new WebLinkType();
			URL url = new URL(it);
			test.isLinkBroken(url, element);
			actualResponsFromServer.add((element.statusLink).toString());

		}

		assertEquals(expectedResponsFromServer, actualResponsFromServer);// checks for results

	}

}
