package guiBrokenLinks;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import javax.swing.JTextField;


public class TextFieldUrl extends JPanel {

	private JTextField textField;

	public TextFieldUrl()
	// constructor
	{

		textField = new JTextField("Enter URL to verify");
		textField.setFont(new Font("Arial",Font.PLAIN,16));
		textField.setPreferredSize(new Dimension(1000,55));
		add(textField);
	}

	public void setUrlFromField(String url)
	// get URL from field
	{
		MainFrameController.url=textField.getText();
	}
}
