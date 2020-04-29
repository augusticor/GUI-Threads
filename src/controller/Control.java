package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import dinamicStructures.SimpleList;
import threads.GUIThread;
import views.ThreadJPanel;
import views.ThreadMainWindow;

/**
 * Shows in graphic user interface how the java threads work, displays lists of numbers at different speed each one
 * Design pattern : M.V.C.
 * Used I.D.E: Eclipse
 * This class is the controller, joins threads, logic and interface
 * @author augusticor
 * @version 2.0
 * @category threads
 * @author augusticor
 */
public class Control implements ActionListener {
	
	/**A random object to generate random values for the speed of the threads*/
	private static final Random RANDOMIZE = new Random();
	/**A simple list data structure*/
	private SimpleList<Integer> simpleList;
	/**An array of threads, will be displayed in GUI*/
	private GUIThread<Integer> threads[];
	/**The main interface object*/
	private ThreadMainWindow mainW;

	@SuppressWarnings("unchecked")
	public Control() {
		simpleList = new SimpleList<>();
		threads = new GUIThread[20];
		mainW = new ThreadMainWindow(this);
		fillSimpleList();
	}

	/**
	 * Listen to the action, when the user click start threads button
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		switch (Actions.valueOf(actionEvent.getActionCommand())) {
		case START_THREADS:
			startThreads();
			break;
		}
	}

	/**
	 * Starts the emulation of the threads and show them in GUI
	 */
	private void startThreads() {
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new GUIThread<>(simpleList, RANDOMIZE.nextInt(2000), new ThreadJPanel());
		}
		mainW.addThreadsToPanel(threads);
	}

	/**
	 * Fills the simple list with random values from 0 to 100, values that gonna be displayed in GUI
	 */
	private void fillSimpleList() {
		for (int i = 0; i < 11; i++) {
			simpleList.add(RANDOMIZE.nextInt(100));
		}
	}
}