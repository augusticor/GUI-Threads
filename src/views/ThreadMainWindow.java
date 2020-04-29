package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import constantsGUI.*;
import controller.Actions;
import threads.GUIThread;

/**
 * The principal window of the program, contains all the threads panels
 * @author augusticor
 */
public class ThreadMainWindow extends JFrame {

	/**A single default panel when no threads are running*/
	private MainPanel mainPanel;

	public ThreadMainWindow(ActionListener listener) {
		setTitle(ConstantsGUI.MAIN_TITLE);
		getContentPane().setBackground(Color.WHITE);
		setMinimumSize(new Dimension(600, 500));
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(createImageIcon(ConstantsIMG.MAIN_ICON).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mainPanel = new MainPanel();
		add(mainPanel, BorderLayout.CENTER);
		
		add(new OwnJButton(ConstantsGUI.BTN_START_THREADS, Actions.START_THREADS.toString(), listener), BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	/**
	 * Adds threads to panel
	 * @param <T> generic type
	 * @param threads array
	 */
	public <T> void addThreadsToPanel(GUIThread<T>[] threads) {
		mainPanel.createThreadsGUI(threads);
	}
	
	/**
	 * Creates an ImageIcon object
	 * @param path of the file in the source files
	 * @return the created ImageIcon object
	 */
	private ImageIcon createImageIcon(String filePath) {
		return new ImageIcon(getClass().getResource(filePath));
	}
}