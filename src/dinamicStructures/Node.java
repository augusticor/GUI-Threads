package dinamicStructures;

public class Node<T> {

	/**The information of the node*/
	protected T info;
	/**The next node in the list after this*/
	protected Node<T> next;

	/**
	 * This constructor method allows to create a new Element with information and the node it will point to another Node
	 * @param info information of the Node
	 * @param next Node 
	 */
	public Node(T info, Node<T> next) {
		this.info = info;
		this.next = next;
	}

	/**
	 * This constructor creates a new Node element with the information and point null
	 * @param info information of the node
	 */
	public Node(T info){
		this.info = info;
		this.next = null;
	}

	/**
	 * @return the information of the node
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * @return the next node in the list
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Sets the information of this node of generic type
	 * @param info to be saved in the node
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * Sets the information of the node ahead of this
	 * @param next
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
}