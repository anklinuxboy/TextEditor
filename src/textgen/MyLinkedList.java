package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) {
		
		// Implement this method
		LLNode<E> node = new LLNode<E>(element);
		// This is the first node
		if (size == 0) {
			head.next = node;
			node.next = tail;
			node.prev = head;
			tail.prev = node;
		} else if (element == null) {
			throw new NullPointerException();
		} else {
			LLNode<E> traverse = head;
			while (traverse.next != tail) {
				traverse = traverse.next;
			}
			traverse.next = node;
			node.prev = traverse;
			node.next = tail;
			tail.prev = node;
		}
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> traverse = head;
		for (int i = 0; i <= index; ++i)
			traverse = traverse.next;
		
		// Implement this method.
		return traverse.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// Implement this method
		if (index == 0 && size == 0) {
			add(element);
		} else if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (element == null) {
			throw new NullPointerException();
		} else {
		
			LLNode<E> node = new LLNode<E>(element);
			LLNode<E> traverse = head;
			for (int i = 0; i < index; ++i)
				traverse = traverse.next;
			
			traverse.next.prev = node;
			node.next = traverse.next;
			node.prev = traverse;
			traverse.next = node;
			size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index)
	{
		// Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> traverse = head;
		for (int i = 0; i < index; ++i)
			traverse = traverse.next;
		LLNode<E> t2 = traverse.next.next;
		E data = traverse.next.data;
		traverse.next.next = null;
		traverse.next.prev = null;
		traverse.next = t2;
		t2.prev = traverse;
		size--;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// Implement this method
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if (element == null)
			throw new NullPointerException();
		LLNode<E> traverse = head;
		for (int i = 0; i <= index; ++i)
			traverse = traverse.next;
		
		E dataReplaced = traverse.data;
		traverse.data = element;
		return dataReplaced;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
