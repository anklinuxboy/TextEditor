/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			String b = shortList.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			int c = emptyList.remove(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // implement this test
		assertEquals("Adding element", true, emptyList.add(1));
		assertEquals("EmptyList Size", 1, emptyList.size());
		assertEquals("Add element", true, list1.add(57));
		assertEquals("Get size", 4, list1.size());
		
		try {
			int a = list1.get(3);
			assertEquals("Check element", 57, a);
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			longerList.add(null);
			fail("Check Null Value");
		} catch (NullPointerException e) {}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// implement this test
		assertEquals("Check size", 3, list1.size());
		assertEquals("Add element", true, longerList.add(11));
		assertEquals("Check size", 11, longerList.size());
		assertEquals("Check size", 0, emptyList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // implement this test
		try {
			emptyList.add(0, 1);
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			emptyList.add(-1, 34);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			shortList.add(0, "C");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			String c = shortList.get(0);
			assertEquals("Equal? ", "C", c);
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			longerList.add(11, 11);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			longerList.add(3, null);
			fail("Check Null Value");
		} catch (NullPointerException e) {}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // implement this test
		try {
			String a = shortList.set(0, "C");
			assertEquals("Check", "A", a);
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			int n = list1.set(4, 5);
			fail("Check out of Bounds");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			int m = list1.set(2, null);
			fail("Check null value");
		} catch (NullPointerException e) {}
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
