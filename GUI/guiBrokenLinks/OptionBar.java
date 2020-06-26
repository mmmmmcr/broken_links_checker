package guiBrokenLinks;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionBar extends JPanel implements ActionListener {

	private JButton sortByNameButton;
	private JButton filterByDownButton;
	private JButton sortByTimeResponseButton;
	private TextFieldUrl textField;
	private TextPanel textPanel;
	private MainFrameController mainFrame;

	public OptionBar()
	// constructor
	{
		sortByNameButton = new JButton("Sort Alphabetically");

		sortByTimeResponseButton = new JButton("Sort by Time Response Server");

		filterByDownButton = new JButton("Show Just Down URL");

		textField = new TextFieldUrl();

		sortByNameButton.addActionListener(this);// to act when you click the button

		sortByTimeResponseButton.addActionListener(this);// to act when you click the button

		filterByDownButton.addActionListener(this);// to act when you click the button

		setLayout(new FlowLayout());
		// add components to JPanel
		add(sortByNameButton);
		add(filterByDownButton);
		add(sortByTimeResponseButton);
		add(textField);
	}

	public void setOptionBar(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	public void getClass(MainFrameController m) {
		this.mainFrame = m;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	// choose what happens when you press a button
	{
		JButton clicked = (JButton) e.getSource();
		if (clicked == sortByNameButton) {
			textPanel.clear();
			mainFrame.runSortByName();

		}
		if (clicked == sortByTimeResponseButton) {
			textPanel.clear();
			mainFrame.runSortByTimeResponseServer();

		}
		if (clicked == filterByDownButton) {
			textPanel.clear();
			mainFrame.runfilterByLinkByDown();

		}

	}

	public void setUrlFromField(String url)
	// get url from field
	{
		textField.setUrlFromField(url);
	}
}
