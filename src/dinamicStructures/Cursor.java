package dinamicStructures;

/**
 * Cursor of the simple list
 * @author augusticor
 * @param <T> generic type for the cursor, can be any type (the list type)
 */
public class Cursor<T> extends SimpleList<T> {

	/**A node that serves as a cursor in the list to scroll*/
    private Node<T> cursor;

    public Cursor(SimpleList<T> simpleList) {
        super(simpleList);
        cursor = head;
    }

    /**
     * @return if the cursor is out of the list
     */
    public boolean isOut() {
        return cursor == null;
    }

    /**
     * Sets the cursor at the head of the list
     */
    public void reset() {
        cursor = this.head;
    }

    /**
     * @return if the cursor is positioned on the last element of the list
     */
    public boolean isLast() {
        return cursor.next == null;
    }

    /**
     * @return the information from the node where the cursor goes
     */
    public T getInfo() {
        return cursor.info;
    }

    /**
     * Changes the position of the cursor one node ahead
     */
    public void next() {
        cursor = cursor.next;
    }

    /**
     * @return the information of the next node where the cursor is 
     */
    public T nextInfo() {
        T aux = cursor.info;
        cursor = cursor.next;
        return aux;
    }
}