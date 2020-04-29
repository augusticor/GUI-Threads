package views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import threads.GUIThread;

/**
 * The panel where shows the real time threads
 * @author augusticor
 */
public class MainPanel extends JPanel {

	public MainPanel() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 3, 5, 0));
	}

	/**
	 * Display the threads in GUI
	 * @param <T> generic type of threads
	 * @param threads the array of threads from controller
	 */
	public <T> void createThreadsGUI(GUIThread<T>[] threads) {
		setLayout(new GridLayout(1, threads.length, 5, 0));
		for (GUIThread<T> guiThread : threads) {
			guiThread.getThreadJPanel().setLayoutToPanel(11);
			add(new JScrollPane(guiThread.getThreadJPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		}
		for (GUIThread<T> guiThread : threads) {
			Thread thread = new Thread(guiThread);
			thread.start();
		}
		revalidate();
	}
}