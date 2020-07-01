package guiBrokenLinks;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class TextPanels extends JPanel {
	private JTextArea textArea;
	private TextFieldUrl textField;

	public TextPanels()
	// constructor
	{
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);// always update the scroll bar to the last element on display

		textField = new TextFieldUrl();
		add(textField, BorderLayout.NORTH);
	}

	// add to screen area
	public void addToScreen(String txt) {
		textArea.append(txt);

	}

	// clear screen area
	public void clear() {
		textArea.setText(null);
	}

	public String getUrlFromField()
	// get url from field
	{
		return textField.getUrlFromField();
	}

}
