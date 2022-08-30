package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ArraySetTest<E>
{
	ArraySet<Integer> tester = new ArraySet<Integer>();
	
	
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
