package guiBrokenLinks;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextFieldUrl extends JPanel {

	private JTextField textField;

	public TextFieldUrl()
	// constructor
	{

		textField = new JTextField("Enter URL to verify      ");
		textField.setPreferredSize(new Dimension(800,40));
		add(textField);
		textField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");//clear field when you place cursor on it

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	public String getUrlFromField()
	// get URL from field
	{
		return textField.getText();

	}
}
