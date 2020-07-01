package brokenLinks;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class SortListByTimeResponseTest {
	private ArrayList<WebLinkType> actualOutput;
	private SortOnListOfLinksAction helper;
	private ArrayList<Integer> actual;
	private WebLinkType temp;
	ArrayList<Integer> expectedTimeResponseServer = new ArrayList<Integer>();
	ArrayList<Integer> inputTimeResponseServer = new ArrayList<Integer>();

	// constructor in order to use automate tests
	public SortListByTimeResponseTest(ArrayList<Integer> expectedTimeResponseServer,
			ArrayList<Integer> inputTimeResponseServer) {
		super();
		this.expectedTimeResponseServer = expectedTimeResponseServer;
		this.inputTimeResponseServer = inputTimeResponseServer;

	}

	@Before
	// initialise the needed variables before every test
	public void init() {
		actualOutput = new ArrayList<WebLinkType>();
		helper = new SortListOfLinksByTimeResponse();
		actual = new ArrayList<Integer>();
	}

	@SuppressWarnings("serial")
	@Parameters
	// parameters(input and output)for automate tests
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { new ArrayList<Integer>() {
			{// expected output
				add(1);
				add(1);
				add(1);
				add(1);
			}
		}, new ArrayList<Integer>() {
			{// input
				add(1);
				add(1);
				add(1);
				add(1);
			}
		} }, { new ArrayList<Integer>() {
			{// expected output
				add(76);
				add(88);
				add(92);
				add(566);
			}
		}, new ArrayList<Integer>() {
			{// input
				add(566);
				add(76);
				add(88);
				add(92);
			}
		} }, { new ArrayList<Integer>() {
			{// expected output
				add(76);
				add(76);
				add(76);
				add(566);
			}
		}, new ArrayList<Integer>() {
			{// input
				add(566);
				add(76);
				add(76);
				add(76);
			}
		} }

		});
	}

	@Test
	public void testSortByTimeResponse() {

		for (Integer it : inputTimeResponseServer) {
			temp = new WebLinkType();
			temp.timeResponseServer = it;
			actualOutput.add(temp);
		}
		helper.sortBy(actualOutput);
		for (WebLinkType it : actualOutput) {
			actual.add(it.timeResponseServer);

		}
		assertEquals(expectedTimeResponseServer, actual);// check weather the output match the expected one or not

	}

}
