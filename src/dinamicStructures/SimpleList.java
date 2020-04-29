package dinamicStructures;

import java.util.Comparator;

/**
 * Simple list data structure
 * @author augusticor
 * @param <T> the type of the simple list (can be any)
 */
public class SimpleList<T> {

	/**A node indicating the head of the list*/
	protected Node<T> head;
	/**A comparator for sort the list*/
	private Comparator<T> comparator;

	/**
	 * Constructor with no comparator
	 */
	public SimpleList() {
		this.head = null;
		this.comparator = null;
	}

	/**
	 * Creates a list with a comparator
	 * @param comparator the comparator to sort the list
	 */
	public SimpleList(Comparator<T> comparator) {
		this.head = null;
		this.comparator = comparator;
	}

	/**
	 * Copies an other simple list
	 * @param simpleList the simplelist to copy
	 */
	public SimpleList(SimpleList<T> simpleList) {
		this.head = simpleList.getHead();
		this.comparator = null;
	}

	/**
	 * Adds and element at the end of the list
	 * @param info to add
	 */
	public void addLast(T info) {
		if (head != null) {
			Node<T> aux = head;
			while (aux.next != null) {
				aux = aux.next;
			}
			aux.next = (new Node<T>(info));
		} else {
			head = new Node<T>(info);
		}
	}

	/**
	 * Inserts an element at the top of the list
	 * @param info to be added type T
	 */
	public void insert(T info) {
		head = new Node<T>(info, head);
	}

	/**
	 * Removes an element of the list
	 * @param info to search into the list and remove it
	 */
	public void remove(T info) {
		if (head != null) {
			if (head.info == info) {
				head = head.next;

			} else {
				Node<T> aux = head.next;
				Node<T> anterior = head;
				while (aux != null) {
					if (aux.info == info) {
						anterior.next = aux.next;
					}

					anterior = aux;
					aux = aux.next;
				}
			}

		}
	}

	/**
	 * Search an element in the list 
	 * @param info to search and find the element
	 * @return the whole element object
	 */
	public T search(T info) {
		if (head != null) {
			Node<T> aux = head.next;
			if (aux.info == info) {
				return aux.info;
			} else {
				while (aux.next != null) {
					aux = aux.next;
					if (aux.info == info) {
						return aux.info;
					}

				}
			}

		}
		return null;
	}

	/**
	 * @return the head node of the list
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * Adds in order to the list if does not have comparator
	 * @param info to add
	 */
	public void add(T info) {
		if (comparator == null) {
			addLast(info);
		} else {
			addSort(info);
		}
	}


	/**
	 * Adds in order to the list, a comparator is required
	 * @param info to be added to the list
	 */
	public void addSort(T info) {
		if (this.head == null) {
			head = new Node<T>(info);
		} else {
			if (comparator.compare(info, head.info) < 0) {
				head = new Node<T>(info, head);
			} else {
				Node<T> ant = head;
				Node<T> aux = head.next;
				while (aux.next != null) {
					ant = aux;
					aux = aux.next;
				}
				ant.next = (new Node<T>(info, aux));
				head = (new Node<T>(info));
			}
		}
	}
}