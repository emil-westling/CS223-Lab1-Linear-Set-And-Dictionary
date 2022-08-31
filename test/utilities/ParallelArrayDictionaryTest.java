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

		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		
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
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();

		// puts mappings in the dictionary
		for(int i = 0; i < STRINGS.length; i++) {
			testDic.put(i, STRINGS[i]);
		}
		// makes sure dictionary is not empty and then 
		for (int i = 0; i < testDic.size(); i++) {
			assertFalse(testDic.isEmpty());
			assertEquals(STRINGS[i], testDic.get(i));
		}
		// tests that the method returns null when the key is not in the dictionary
		assertNull(testDic.get(testDic.size() + 1));
	}

	/**
	 * Creates a ParallelArrayDictionary and tests the put() method on the dictionary. First by adding key-value
	 * mappings that do not already exist in the dictionary. Then by calling it with a key that is already in the 
	 * dictionary
	 * */
	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		
		// testing to put new key-value mappings in the dictionary
		for (int i = 0; i < STRINGS.length; i++) {
			testDic.put(i, STRINGS[i]);
			assertTrue(!testDic.isEmpty());
			assertTrue(testDic.get(i) == STRINGS[i]);
			assertTrue(testDic.containsValue(STRINGS[i]));
		}
		// tests put when the key is already in the dictionary
		int newKey = 2;
		String oldValue = testDic.put(newKey, STRINGS[newKey+1]);
		assertTrue(oldValue == STRINGS[newKey]);
		assertTrue(testDic.get(newKey) == STRINGS[newKey+1]);
	}

	/**
	 * creates a ParallelArrayDictionary and tests the remove method by removing key-value mappings from a 
	 * dictionary with 5 mappings. Then, tests the remove method by calling it on an empty dictionary. 
	 * */
	@Test
	void testRemove()
	{

		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		
		for(int i = 0; i < STRINGS.length; i++) {
			testDic.put(i, STRINGS[i]);
		}
		assertTrue(!testDic.isEmpty() && testDic.size() == STRINGS.length);
		
		// removes elements from dictionary, stores the removed value and checks if it is the correct value,
		// checks so that the the key-value mapping has been removed, finally makes sure the list is not empty 
		for (int i = 0; i < STRINGS.length/2; i++) {
			String oldValue = testDic.remove(i);
			assertTrue(oldValue == STRINGS[i]);
			assertFalse(testDic.containsKey(i) && testDic.containsValue(oldValue));
			assertFalse(testDic.isEmpty());
		}
		
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
		
		// creating a map and which is then passed as an argument for the method call
		Map<Integer, String> map = new ParallelArrayDictionary<>();
		for(int i = 0; i < STRINGS.length; i++)
			map.put(i, STRINGS[i]);
		testDic.putAll(map);
		
		// makes sure all key-value mappings have been added to the dictionary
		for (int i = 0; i < testDic.size(); i++) {
			assertTrue(testDic.containsKey(i) && testDic.get(i) == STRINGS[i]);			
		}
		
		// clears map, tests that it is empty and adds new elements to it
		map.clear();
		assertTrue(map.isEmpty());
		for (int i = STRINGS.length; i < additionalStrings.length + 5; i++) {
			map.put(i, additionalStrings[i - STRINGS.length]);
		}
		testDic.putAll(map);
		// tests so that all key-value mappings have been added to the dictionary
		for (int i = STRINGS.length; i < additionalStrings.length + 5; i++) {
			assertTrue(testDic.containsKey(i) && testDic.get(i) == additionalStrings[i - STRINGS.length]);
		}
	}

	/**
	 * 
	 * */
	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		
		// tests calling isEmpty on an empty dictionary
		assertTrue(testDic.isEmpty());
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
