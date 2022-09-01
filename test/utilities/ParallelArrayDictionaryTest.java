package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	/**
	 * Used to initialize and fill each test dictionary
	 * */
	private static final Collection<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
	private static final ArraySet<Integer> INTEGERS = new ArraySet<>(arr);
	private static final String[] STRINGS =  {"zero", "one", "two", "three", "four"};
	
	@Test
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>();
		//ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<Integer, String>();
		
		// tests that the constructor created an object
		assertNotNull(testerArrayDictionary);
		assertEquals(testerArrayDictionary.size(), 0);
		assertTrue(testerArrayDictionary.isEmpty());
	}

	/**
	 * tests get() by getting elements that do exist and then by getting nonexisting elements
	 * */
	@Test
	void testGet()
	{
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<Integer, String>();
		
		// puts mappings in the dictionary
		for(int i = 0; i < STRINGS.length; i++) {
			testDic.put(i, STRINGS[i]);
		}
		
		// makes sure dictionary is not empty and then tests the get() method
		assertFalse(testDic.isEmpty());
		assertEquals(STRINGS[STRINGS.length - 2], testDic.get(STRINGS.length - 2));
		
		// tests that the method returns null when the key is not in the dictionary
		assertNull(testDic.get(STRINGS.length));
	}

	/**
	 *tests put() by replacing value 3
	 * */
	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> testDic = 
				new ParallelArrayDictionary<Integer, String>();
		
		// puts new key-value mappings in the dictionary and then
		// makes sure the dictionary is not empty, and that the mapping
		// was added
		testDic.put(0, STRINGS[0]);
		assertFalse(testDic.isEmpty());
		assertTrue(testDic.containsValue(STRINGS[0]));
		assertTrue(testDic.containsKey(0));
				
		testDic.put(1,  STRINGS[1]);
		assertFalse(testDic.isEmpty());
		assertTrue(testDic.containsValue(STRINGS[1]));
		assertTrue(testDic.containsKey(1));
				
		// tests to put a key-value mapping when the key already exists
		// makes sure the list is not empty, then checks the previous 
		// value mapped to the key, and finally checks if the new mapping
		// is added
		int newKey = 1;
		String oldValue = testDic.put(newKey, STRINGS[newKey+1]);
		assertFalse(testDic.isEmpty());
		assertEquals(STRINGS[newKey], oldValue);
		assertEquals(STRINGS[newKey+1], testDic.get(newKey));
	}

	/**
	 * test method for remove(). Firstly tests to remove a key-value mapping that does exist and then by 
	 * passing a nonexisting key-value mapping
	 * 
	 * */
	@Test
	void testRemove()
	{
		
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<Integer, String>();
		
		// puts key-value mappings in the dictionary
		for(int i = 0; i < STRINGS.length; i++) {
			testDic.put(i, STRINGS[i]);
		}
		
		// removes element from dictionary, stores the removed value and checks if it is the correct value, then 
		// checks that the key-value mapping has been removed, finally makes sure the list is not empty 
		String oldValue = testDic.remove(0);
		assertEquals(STRINGS[0], oldValue);
		assertFalse(testDic.containsKey(0));
		assertFalse(testDic.containsValue(oldValue));
		assertFalse(testDic.isEmpty());

		
		// makes sure null is returned when a nonexisting key is passed as input
		Integer nullTest = 15;
		assertNull(testDic.remove(nullTest));
		assertFalse(testDic.isEmpty());
	}

	/**
	 * tests putAll(Map) by creating a map and adding it to a dictionary. First by calling it on an 
	 * empty dictionary and then by calling it on a nonempty dictionary
	 */
	@Test
	void testPutAll()
	{		
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		String[] additionalStrings = {"five", "six", "seven"};
		
		// creating a map and which is then passed as input
		Map<Integer, String> map = new ParallelArrayDictionary<Integer, String>();
		for(int i = 0; i < STRINGS.length; i++) {
			map.put(i, STRINGS[i]);
		}
		testDic.putAll(map);
		
		// makes sure all key-value mappings have been added to the dictionary
		for (int i = 0; i < testDic.size(); i++) {
			assertTrue(testDic.containsKey(i));
			assertEquals(STRINGS[i], testDic.get(i));		
		}	
		
		// clears the input map and adds new elements to it
		map.clear();
		for (int i = STRINGS.length; i < additionalStrings.length + STRINGS.length; i++) {
			map.put(i, additionalStrings[i - STRINGS.length]);
		}
		
		// calls putAll(map) on a nonempty map
		testDic.putAll(map);
		// controls that all key-value mappings have been added to the dictionary
		for (int i = STRINGS.length; i < additionalStrings.length + STRINGS.length; i++) {
			assertTrue(testDic.containsKey(i));
			assertEquals(additionalStrings[i - STRINGS.length], testDic.get(i));
		}
	}

	/**
	 * tests clear() on both an empty dictionary and a nonempty dictionary
	 * */
	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, String> testClear = new ParallelArrayDictionary<Integer, String>();
		
		// calling on empty dictionary
		assertTrue(testClear.isEmpty());
		testClear.clear();
		assertTrue(testClear.isEmpty());
		assertNotNull(testClear);
		assertEquals(testClear.size(), 0);
		
		// puts key-value mappings in the dictionary
		for(int i = 0; i < STRINGS.length; i++) {
			testClear.put(i, STRINGS[i]);
		}
		
		// calling on a nonempty dictionary
		testClear.clear();
		assertTrue(testClear.isEmpty());
		assertNotNull(testClear);
		assertEquals(testClear.size(), 0);
	}
}
