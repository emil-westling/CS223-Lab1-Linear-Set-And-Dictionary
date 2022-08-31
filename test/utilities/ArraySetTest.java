package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ArraySetTest<E>
{
	/**
	 * ArraySet tester is used in test of ArraySet methods and utilizes Integer objects
	 * */
	ArraySet<Integer> tester = new ArraySet<Integer>();
	private static final int SIZE_OF_LIST_TEST = 5;
	
	/**
	 * checks size() and isEmpty() methods on both empty sets and nonempty sets. 
	 */
	@Test
	public void testSize() {
		ArraySet<Integer> sizeTest = new ArraySet<Integer>();
		
		// size 0
		assertTrue(sizeTest.size() == 0);
		assertTrue(sizeTest.isEmpty() == true);
		
		for (int i = 0; i < SIZE_OF_LIST_TEST; i++) {
			tester.add(i);
			assertTrue(sizeTest.size() == i + 1);
			assertFalse(sizeTest.isEmpty());
			assertNotSame(0, sizeTest.size());
		}
		
		assertTrue(sizeTest.size() == 5);
	}
	
	/**
	 * Test constructor for array set that auto-fills the set with give collection
	 * */
	@Test
	void testArraySetCollectionOfE()
	{
		tester.clear();
		ArrayList<Integer> collection = new ArrayList<Integer>();
		for(int i = 0; i < 4; i ++) 
		{
			collection.add(i);
		}
		
		ArraySet<Integer> testSecConstructor = new ArraySet<Integer>(collection);
		
		assertTrue(!testSecConstructor.isEmpty() && testSecConstructor.containsAll(collection));
	}

	/**
	 * tests add() using Integer objects
	 * */
	@Test
	void testAddE()
	{
		tester.clear();
		assertTrue(tester.add(1));
	}

	/**
	 * tests addAll() using collection of Integer objects
	 * */
	@Test
	void testAddAllCollectionOfQextendsE()
	{
		tester.clear();
		ArrayList<Integer> collectionArrayList = new ArrayList<Integer>();
		for(int i = 0; i < 4; i ++) 
		{
			collectionArrayList.add(i);
		}
		
		assertTrue(tester.addAll(collectionArrayList));
	}

	/**
	 * tests retainAll() using Integer objects
	 * */
	@Test
	void testRetainAll()
	{
		tester.clear();
		for(int i = 0; i < 10; i++) 
		{
			tester.add(i);
		}
		
		assertTrue(tester.retainAll(tester.subList(1, 4)));
	}

	/**
	 * tests removeAll() using Integer objects
	 * */
	@Test
	void testRemoveAll()
	{
		tester.clear();
		for(int i = 0; i < 10; i++) 
		{
			tester.add(i);
		}
		
		assertTrue(tester.removeAll(tester.subList(1, 4)));
	}

	/**
	 * tests addAll() with specified index using collection of Integer objects
	 * */
	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		tester.clear();
		ArrayList<Integer> collectionArrayList = new ArrayList<Integer>();
		int after = 2;
		for(int i = 0; i < 4; i ++) 
		{
			collectionArrayList.add(i);
		}
		
		assertTrue(tester.addAll(after, collectionArrayList));
	}
}
