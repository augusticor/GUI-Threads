package views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * The panel for showing a single thread in the main window
 * @author augusticor
 */
public class ThreadJPanel extends JPanel {

	public ThreadJPanel() {
		setBackground(Color.WHITE);
	}
	
	/**
	 * Paints an element in the panel
	 * @param info element to be painted
	 */
	public void paintCurrentElement(String info) {
		add(new OwnJLabel(info));
		revalidate();
	}
	
	/**
	 * Creates a layout depending the size of the threads array
	 * @param rows number of rows, the size of the threads array
	 */
	public void setLayoutToPanel(int rows) {
		setLayout(new GridLayout(rows, 1));
	}
}