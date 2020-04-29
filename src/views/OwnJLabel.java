package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import constantsGUI.*;

/**
 * A class for creating multiple elements of labels and reuse them
 * @author augusticor
 */
public class OwnJLabel extends JLabel {

	public OwnJLabel(String t) {
		setText(t);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font(ConstantsGUI.CONSOLAS_LABEL_FONT, 1, 12));
		setHorizontalAlignment(JLabel.CENTER);
	}
}