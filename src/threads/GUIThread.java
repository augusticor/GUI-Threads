package threads;

import dinamicStructures.Cursor;
import dinamicStructures.SimpleList;
import views.ThreadJPanel;

/**
 * Creates the threads that run through the simple lists
 * @author augusticor
 * @param <T>
 */
public class GUIThread<T> extends Cursor<T> implements Runnable {

	/**The information at a moment in the thread*/
	protected T currentInfo;
	/**The time to sleep the thread milliseconds*/
	private long threadTime;
	/**The panel object to show the threads in interface and real time*/
	private ThreadJPanel threadJPanel;

	public GUIThread(SimpleList<T> simpleList, long threadTime, ThreadJPanel threadJPanel) {
		super(simpleList);
		currentInfo = null;
		this.threadTime = threadTime;
		this.threadJPanel = threadJPanel;
	}

	/**
	 * run method for running the thread, prints on the console the item being browsed in the list
	 */
	@Override
	public void run() {
		while (!this.isOut()) {
			this.currentInfo = this.nextInfo();
			threadJPanel.paintCurrentElement(currentInfo + "");
			System.out.println(Thread.currentThread().getName() + " Inf:" + currentInfo + " Time:" + threadTime);
			try {
				Thread.sleep(threadTime);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		System.out.println(Thread.currentThread().getName() + " ha finalizado !");
	}

	/**
	 * @return the info in the list
	 */
	public T getCurrentInfo() {
		return currentInfo;
	}

	/**
	 * @return the panel object with new elements
	 */
	public ThreadJPanel getThreadJPanel() {
		return threadJPanel;
	}
}