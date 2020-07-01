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

import brokenLinks.WebLinkType.status;

@RunWith(Parameterized.class)

public class FilterByDownStatusTest {
	private ArrayList<WebLinkType> actualOutput;
	private ArrayList<WebLinkType> functionReturnResultHelper;
	private FilterListOfLinksByAction helper;
	private ArrayList<status> actualStatusOutputConvertedToArrayList;
	private WebLinkType temp;
	ArrayList<status> expectedServerStatus = new ArrayList<status>();
	ArrayList<status> inputServerStatus = new ArrayList<status>();

	// constructor in order to use automate tests
	public FilterByDownStatusTest(ArrayList<status> expectedServerStatus, ArrayList<status> inputServerStatus) {
		super();
		this.expectedServerStatus = expectedServerStatus;
		this.inputServerStatus = inputServerStatus;

	}

	@Before
	// initialise the needed variables before every test
	public void init() {
		actualOutput = new ArrayList<WebLinkType>();
		functionReturnResultHelper = new ArrayList<WebLinkType>();
		helper = new FilterListOfLinksByDown();
		actualStatusOutputConvertedToArrayList = new ArrayList<status>();
	}

	@SuppressWarnings("serial")
	@Parameters
	// parameters(input and output)for automate tests
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { new ArrayList<status>() {
			{// expected output
				add(status.DOWN);

			}
		}, new ArrayList<status>() {
			{// input
				add(status.UP);
				add(status.UP);
				add(status.DOWN);
				add(status.UP);
			}
		} }, { new ArrayList<status>() {
			{// expected output
				// empty list

			}
		}, new ArrayList<status>() {
			{// input
				add(status.UP);
				add(status.UP);
				add(status.UP);
				add(status.UP);
			}
		} }, { new ArrayList<status>() {
			{// expected output
				add(status.DOWN);
				add(status.DOWN);
			}
		}, new ArrayList<status>() {
			{// input
				add(status.DOWN);
				add(status.UP);
				add(status.DOWN);
				add(status.UP);
			}
		} }

		});
	}

	@Test
	public void testFilterByDown() {

		for (status it : inputServerStatus) {
			temp = new WebLinkType();
			temp.statusLink = it;
			actualOutput.add(temp);
		}
		functionReturnResultHelper = (ArrayList<WebLinkType>) helper.filterBy(actualOutput);
		for (WebLinkType it : functionReturnResultHelper) {
			actualStatusOutputConvertedToArrayList.add(it.statusLink);

		}
		assertEquals(expectedServerStatus, actualStatusOutputConvertedToArrayList);// check weather the output match the
																					// expected one or not

	}

}
