package guiBrokenLinks;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OptionBar extends JPanel implements ActionListener {

	private JButton sortByNameButton;
	private JButton filterByDownButton;
	private JButton sortByTimeResponseButton;
	private TextPanels textPanel;
	private MainFrameController mainFrame;

	public OptionBar()
	// constructor
	{
		sortByNameButton = new JButton("Sort Alphabetically");

		sortByTimeResponseButton = new JButton("Sort by Time Response Server");

		filterByDownButton = new JButton("Show Just Down URL");

		sortByNameButton.addActionListener(this);// to act when you click the button

		sortByTimeResponseButton.addActionListener(this);// to act when you click the button

		filterByDownButton.addActionListener(this);// to act when you click the button

		setLayout(new FlowLayout());
		// add components to JPanel
		add(sortByNameButton);
		add(filterByDownButton);
		add(sortByTimeResponseButton);
	
	}

	public void setOptionBar(TextPanels textPanel) {
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

}
