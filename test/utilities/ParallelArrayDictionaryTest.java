package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	/**
	 * Used to initialize and fill each test dictionary
	 * */
	private static final Collection<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
	private static final ArraySet<Integer> INTEGERS = new ArraySet<>(arr);
	private static final ArrayList<String> STRINGS = 
			new ArrayList<>(Arrays.asList("zero", "one", "two", "three", "four"));
	
	
	@Test
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>();
		
		// tests that the constructor created an object
		assertNotNull(testerArrayDictionary);
		assertEquals(testerArrayDictionary.size(), 0);
		assertTrue(testerArrayDictionary.isEmpty());
	}

	/**
	 * 
	 * */
	@Test
	void testGet()
	{
		ParallelArrayDictionary<Integer, String> testGet = 
				new ParallelArrayDictionary<>(INTEGERS, STRINGS);
		
		for(int i = 0; i < testGet.size(); i++) 
		{
			assertEquals(testGet.get(INTEGERS.get(i)), STRINGS.get(i));
			assertFalse(testGet.isEmpty());
		}
		
		assertNull(testGet.get(7));
	}

	/**
	 *
	 * */
	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> testPut = 
				new ParallelArrayDictionary<>(INTEGERS, STRINGS);
		
		Integer replacementKey = 3;
		Integer nullTest = 15;
		String replcementValue = "replaced";
		
		assertEquals(testPut.get(replacementKey), "three");
		
		testPut.put(replacementKey, replcementValue);
		assertEquals(testPut.get(replacementKey), "replaced");
		assertNull(testPut.put(nullTest, replcementValue));
		
		/*
		// testing to put new key-value mappings in the dictionary
		for (int i = 0; i < strings.length; i++) {
			testerArrayDictionary.put(i, strings[i]);
			assertTrue(!testerArrayDictionary.isEmpty());
			assertTrue(testerArrayDictionary.get(i) == strings[i]);
			assertTrue(testerArrayDictionary.containsValue(strings[i]));
		}
		// tests put when the key is already in the dictionary
		int newKey = 2;
		String oldValue = testerArrayDictionary.put(newKey, strings[newKey+1]);
		assertTrue(oldValue == strings[newKey]);
		assertTrue(testerArrayDictionary.get(newKey) == strings[newKey+1]);
		*/
	}

	/**
	 * 
	 * */
	@Test
	void testRemove()
	{
		ParallelArrayDictionary<Integer, String> testRemove = 
				new ParallelArrayDictionary<>(INTEGERS, STRINGS);
		
		/*
		for(int i = 0; i < strings.length; i++) {
			testerArrayDictionary.put(i, strings[i]);
		}
		assertTrue(!testerArrayDictionary.isEmpty() && testerArrayDictionary.size() == strings.length);
		
		// removes elements from dictionary, stores the removed value and checks if it is the correct value,
		// checks so that the the key-value mapping has been removed, finally makes sure the list is not empty 
		for (int i = 0; i < strings.length/2; i++) {
			String oldValue = testerArrayDictionary.remove(i);
			assertTrue(oldValue == strings[i]);
			assertFalse(testerArrayDictionary.containsKey(i) && testerArrayDictionary.containsValue(oldValue));
			assertFalse(testerArrayDictionary.isEmpty());
		}
		
		int keyToDelete = 1;
		testerArrayDictionary.clear();
		assertTrue(testerArrayDictionary.isEmpty());
		assertNull(testerArrayDictionary.remove(keyToDelete));
		*/
	}

	/**
	 * 
	 */
	@Test
	void testPutAll()
	{
		ParallelArrayDictionary<Integer, String> testPutAll = 
				new ParallelArrayDictionary<>(INTEGERS, STRINGS);

		/*
		String[] additionalStrings = {"five", "six", "seven"};
		
		// creating a map and which is then passed as an argument for the method call
		Map<Integer, String> map = new ParallelArrayDictionary<>();
		for(int i = 0; i < strings.length; i++)
			map.put(i, strings[i]);
		testerArrayDictionary.putAll(map);
		
		// makes sure all key-value mappings have been added to the dictionary
		for (int i = 0; i < testerArrayDictionary.size(); i++) {
			assertTrue(testerArrayDictionary.containsKey(i) && testerArrayDictionary.get(i) == strings[i]);			
		}
		
		// clears map, tests that it is empty and adds new elements to it
		map.clear();
		assertTrue(map.isEmpty());
		for (int i = strings.length; i < additionalStrings.length + 5; i++) {
			map.put(i, additionalStrings[i - strings.length]);
		}
		testerArrayDictionary.putAll(map);
		// tests so that all key-value mappings have been added to the dictionary
		for (int i = strings.length; i < additionalStrings.length + 5; i++) {
			assertTrue(testerArrayDictionary.containsKey(i) && testerArrayDictionary.get(i) == additionalStrings[i - strings.length]);
		}
		*/
	}

	/**
	 * 
	 * */
	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, String> testClear = 
				new ParallelArrayDictionary<>(INTEGERS, STRINGS);
		
		assertFalse(testClear.isEmpty());
		
		testClear.clear();
		assertTrue(testClear.isEmpty());
		assertNotNull(testClear);
		assertEquals(testClear.size(), 0);
	}
}
