package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	private static final String[] STRINGS = {"zero", "one", "two", "three", "four"};
	
	@Test
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<Integer, String>();
		
		// tests that the constructor created an object
		assertEquals(0, testDic.size());
		assertTrue(testDic.isEmpty());
	}

	/**
	 * Creates a ParallelArrayDictionary and tests the functionality of the get() method. Firstly by calling it 
	 * on an empty dictionary and secondly by calling it on a dictionary with 5 elements. 
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
	 * Creates a ParallelArrayDictionary and tests the put() method on the dictionary. First by adding key-value
	 * mappings that do not already exist in the dictionary. Then by calling it with a key that is already in the 
	 * dictionary
	 * */
	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<Integer, String>();
		
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
	 * creates a ParallelArrayDictionary and tests the remove method by removing key-value mappings from a 
	 * dictionary with 5 mappings. Then, tests the remove method by calling it on an empty dictionary. 
	 * */
	@Test
	void testRemove()
	{

		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		
		// puts key-value mappings in the dictionary
		for(int i = 0; i < STRINGS.length; i++) {
			testDic.put(i, STRINGS[i]);
		}
		assertTrue(!testDic.isEmpty() && testDic.size() == STRINGS.length);
		
		// removes element from dictionary, stores the removed value and checks if it is the correct value, then 
		// checks that the key-value mapping has been removed, finally makes sure the list is not empty 
		String oldValue = testDic.remove(0);
		assertEquals(STRINGS[0], oldValue);
		assertFalse(testDic.containsKey(0));
		assertFalse(testDic.containsValue(oldValue));
		assertFalse(testDic.isEmpty());
		
		// tests if null is returned when a nonexistent key is passed as input
		int keyToDelete = 1;
		testDic.clear();
		assertTrue(testDic.isEmpty());
		assertNull(testDic.remove(keyToDelete));
	}

	/**
	 * Creates a ParallelArrayDictionary and tests the functionality of putAll(Map) method on the 
	 * dictionary. First by creating a map and passing it to an empty dictionary, and then by 
	 * creating a map and passing it to a nonempty dictionary.
	 */
	@Test
	void testPutAll()
	{
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		String[] additionalStrings = {"five", "six", "seven"};
		
		// creating a map and which is then passed as input
		Map<Integer, String> map = new ParallelArrayDictionary<>();
		for(int i = 0; i < STRINGS.length; i++)
			map.put(i, STRINGS[i]);
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
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		
		// tests calling isEmpty on an empty dictionary
		testDic.clear();
		assertTrue(testDic.isEmpty());
		
		// adds mappings to the dictionary
		for(int i = 0; i < STRINGS.length; i++) {
			testDic.put(i, STRINGS[i]);
		}
		
		// tests calling isEmpty on a nonempty dictionary
		assertFalse(testDic.isEmpty());
		testDic.clear();
		assertTrue(testDic.isEmpty());
	}
}
