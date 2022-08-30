package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ArraySetTest<E>
{
	//ArraySet<E> tester = new ArraySet<E>();
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
	
	@Test
	void testArraySetCollectionOfE()
	{
		
	}

	@Test
	void testAddE()
	{
		assertTrue(tester.add(1));
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
		ArrayList<Integer> collectionArrayList = new ArrayList<Integer>();
		for(int i = 0; i < 4; i ++) 
		{
			collectionArrayList.add(i);
		}
		
		assertTrue(tester.addAll(collectionArrayList));
	}

	@Test
	void testRetainAll()
	{
		for(int i = 0; i < 10; i++) 
		{
			tester.add(i);
		}
		
		assertTrue(tester.retainAll(tester.subList(1, 4)));
	}

	@Test
	void testRemoveAll()
	{
		for(int i = 0; i < 10; i++) 
		{
			tester.add(i);
		}
		
		assertTrue(tester.removeAll(tester.subList(1, 4)));
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		ArrayList<Integer> collectionArrayList = new ArrayList<Integer>();
		int after = 2;
		for(int i = 0; i < 4; i ++) 
		{
			collectionArrayList.add(i);
		}
		
		assertTrue(tester.addAll(after, collectionArrayList));
	}
}
