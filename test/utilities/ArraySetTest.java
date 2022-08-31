package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;

class ArraySetTest<E>
{	
	/**
	 * Test constructor for array set that auto-fills the set with give collection
	 * */
	@Test
	void testArraySetCollectionOfE()
	{
		Collection<Integer> collection = new ArrayList<>();
		for(int i = 0; i < 4; i ++) 
			collection.add(i);
		
		ArraySet<Integer> testSecConstructor = new ArraySet<>(collection);
		
		assertFalse(testSecConstructor.isEmpty());
		assertTrue(testSecConstructor.containsAll(collection));
	}

	/**
	 * tests add() using Integer objects
	 * */
	@Test
	void testAddE()
	{
		ArraySet<Integer> testAdd = new ArraySet<Integer>();
		assertTrue(testAdd.isEmpty());
		testAdd.add(1);
		assertTrue(testAdd.contains(1));
	}

	/**
	 * tests addAll() using collection of Integer objects
	 * */
	@Test
	void testAddAllCollectionOfQextendsE()
	{
		ArraySet<Integer> testAddAll = new ArraySet<Integer>();
		assertTrue(testAddAll.isEmpty());
		ArrayList<Integer> collectionArrayList = new ArrayList<Integer>();
		
		//fill collection to be added
		for(int i = 0; i < 4; i ++) 
		{
			collectionArrayList.add(i);
		}
		assertTrue(testAddAll.isEmpty());
		testAddAll.addAll(collectionArrayList);
		assertTrue(testAddAll.containsAll(collectionArrayList));
	}

	/**
	 * tests retainAll() using Integer objects
	 * */
	@Test
	void testRetainAll()
	{
		ArraySet<Integer> testRetainAll = new ArraySet<Integer>();
		assertTrue(testRetainAll.isEmpty());
		
		//fills arraySet
		for(int i = 0; i < 10; i++)
		{
			testRetainAll.add(i);
			assertFalse(testRetainAll.isEmpty());
			assertTrue(testRetainAll.get(i).equals(i));
		}
		
		assertTrue(testRetainAll.retainAll(testRetainAll.subList(1, 4)));
	}

	/**
	 * tests removeAll() using Integer objects
	 * */
	@Test
	void testRemoveAll()
	{
		ArraySet<Integer> testRemoveAll = new ArraySet<Integer>();
		assertTrue(testRemoveAll.isEmpty());
		
		//fills arraySet
		for(int i = 0; i < 10; i++) 
		{
			testRemoveAll.add(i);
			assertFalse(testRemoveAll.isEmpty());
			assertTrue(testRemoveAll.get(i).equals(i));
		}
		
		assertTrue(testRemoveAll.removeAll(testRemoveAll.subList(1, 4)));
	}

	/**
	 * tests addAll() with specified index using collection of Integer objects
	 * */
	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		ArraySet<Integer> testAddAllIndex = new ArraySet<Integer>();
		assertTrue(testAddAllIndex.isEmpty());
		ArrayList<Integer> collectionArrayList = new ArrayList<Integer>();
		int after = 2;
		
		//fills arraySet
		for(int i = 0; i < 5; i++)
		{
			testAddAllIndex.add(i);
			assertFalse(testAddAllIndex.isEmpty());
			assertTrue(testAddAllIndex.get(i).equals(i));
		}
		
		//fills collection to be added
		for(int i = 0; i < 4; i ++)
			collectionArrayList.add(i);
		
		assertTrue(testAddAllIndex.addAll(after, collectionArrayList));
	}
}
