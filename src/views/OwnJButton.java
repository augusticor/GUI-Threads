package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import constantsGUI.ConstantsGUI;

/**
 * A class for creating multiple elements of button and reuse them
 * @author augusticor
 */
public class OwnJButton extends JButton {

	public OwnJButton(String text, String actionCommand, ActionListener actionL) {
		setText(text);
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font(ConstantsGUI.CONSOLAS_LABEL_FONT, 0, 20));
		setBorderPainted(false);
		setActionCommand(actionCommand);
		addActionListener(actionL);
	}
}