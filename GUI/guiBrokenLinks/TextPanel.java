package guiBrokenLinks;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	private JTextArea textArea;

	public TextPanel()
	// constructor
	{
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	// add to screen area
	public void addToScreen(String txt) {
		textArea.append(txt);

	}

	// clear screen area
	public void clear() {
		textArea.setText(null);
	}

}
