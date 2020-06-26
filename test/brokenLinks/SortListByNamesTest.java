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

public class SortListByNamesTest {
	private ArrayList<WebLinkType> actualOutput;
	private SortOnListOfLinksAction helper;
	private ArrayList<String> actualConvertedToArrayList;
	private WebLinkType temp;
	ArrayList<String> expectedOrderOfNames = new ArrayList<String>();
	ArrayList<String> inputOrderOfNames = new ArrayList<String>();

	// constructor in order to use automate tests
	public SortListByNamesTest(ArrayList<String> expectedOrderOfNames, ArrayList<String> inputOrderOfNames) {
		super();
		this.expectedOrderOfNames = expectedOrderOfNames;
		this.inputOrderOfNames = inputOrderOfNames;

	}

	@Before
	// initialise the needed variables before every test
	public void init() {
		actualOutput = new ArrayList<WebLinkType>();
		helper = new SortListOfLinksByName();
		actualConvertedToArrayList = new ArrayList<String>();
	}

	@Parameters
	// parameters(input and output)for automate tests
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { new ArrayList<String>() {
			{ // expected output
				add("https://www.4tuning.ro/");
				add("https://www.realitatea.net/");
				add("https://www.tutorialspoint.com/junit/junit_parameterized_test.htm");
			}
		}, new ArrayList<String>() {
			{ // input
				add("https://www.tutorialspoint.com/junit/junit_parameterized_test.htm");
				add("https://www.4tuning.ro/");
				add("https://www.realitatea.net/");
			}
		} }, { new ArrayList<String>() {
			{ // expected output
				add("https://www.4tuning.ro/");
				add("https://www.4tuning.ro/");
				add("https://www.tutorialspoint.com/junit/junit_parameterized_test.htm");
			}
		}, new ArrayList<String>() {
			{ // input
				add("https://www.tutorialspoint.com/junit/junit_parameterized_test.htm");
				add("https://www.4tuning.ro/");
				add("https://www.4tuning.ro/");
			}
		} },

		});
	}

	@Test
	public void testSortByName() {

		for (String it : inputOrderOfNames) {
			temp = new WebLinkType();
			temp.url = it;
			actualOutput.add(temp);
		}
		helper.sortBy(actualOutput);
		for (WebLinkType it : actualOutput) {
			actualConvertedToArrayList.add(it.url);
			
		}
		assertEquals(expectedOrderOfNames, actualConvertedToArrayList);// checks for results

	}

}
