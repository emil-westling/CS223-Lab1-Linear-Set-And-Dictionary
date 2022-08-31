package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	

	private static final String[] strings = {"zero", "one", "two", "three", "four"};
	
	@Test
	void testParallelArrayDictionary()
	{
		ArrayList<String> values = new ArrayList<String>();
		ArraySet<Integer> keys = new ArraySet<Integer>();
		ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>(keys, values);
		
		// tests that the constructor created an object
		assertNotNull(testerArrayDictionary);
	}

	/**
	 * Creates a ParallelArrayDictionary and tests the functionality of the get() method. Firstly by calling it 
	 * on an empty dictionary and secondly by calling it on a dictionary with 5 elements. 
	 * */
	@Test
	void testGet()
	{
		ArrayList<String> values = new ArrayList<String>();
		ArraySet<Integer> keys = new ArraySet<Integer>();
		ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>(keys, values);
		
		testerArrayDictionary.clear();
		assertTrue(testerArrayDictionary.isEmpty());
		assertNull(testerArrayDictionary.get(keys.get(1)));
		assertNull(testerArrayDictionary.get(keys.get(0)));
		
		for(int i = 0; i < strings.length; i++) {
			testerArrayDictionary.put(i, strings[i]);
		}
		for (int i = 0; i < keys.size(); i++) {
			assertTrue(!testerArrayDictionary.isEmpty() && strings[i] == testerArrayDictionary.get(i));
		}
	}

	/**
	 * Creates a ParallelArrayDictionary and tests the put() method on the dictionary. First by adding key-value
	 * mappings that do not already exist in the dictionary. Then by calling it with a key that is already in the 
	 * dictionary
	 * */
	@Test
	void testPut()
	{
		ArrayList<String> values = new ArrayList<String>();
		ArraySet<Integer> keys = new ArraySet<Integer>();
		ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>(keys, values);
		
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
	}

	/**
	 * creates a ParallelArrayDictionary and tests the remove method by removing key-value mappings from a 
	 * dictionary with 5 mappings. Then, tests the remove method by calling it on an empty dictionary. 
	 * */
	@Test
	void testRemove()
	{
		ArrayList<String> values = new ArrayList<String>();
		ArraySet<Integer> keys = new ArraySet<Integer>();
		ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>(keys, values);
		
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
	}

	/**
	 * Creates a ParallelArrayDictionary and tests the functionality of putAll(Map) method on the 
	 * dictionary. First by creating a map and passing it to an empty dictionary, and then by 
	 * creating a map and passing it to a nonempty dictionary.
	 */
	@Test
	void testPutAll()
	{
		ArrayList<String> values = new ArrayList<String>();
		ArraySet<Integer> keys = new ArraySet<Integer>();
		ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>(keys, values);
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
		for (int i = 5; i < additionalStrings.length + 5; i++) {
			map.put(i, additionalStrings[i]);
		}
		
		// tests so that all key-value mappings have been added to the dictionary
		for (int i = 5; i < additionalStrings.length + 5; i++) {
			assertTrue(testerArrayDictionary.containsKey(i) && testerArrayDictionary.get(i) == additionalStrings[i]);
		}
	}

	/**
	 * 
	 * */
	@Test
	void testClear()
	{
		ArrayList<String> values = new ArrayList<String>();
		ArraySet<Integer> keys = new ArraySet<Integer>();
		ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>(keys, values);
		
		// tests calling isEmpty on an empty dictionary
		assertTrue(testerArrayDictionary.isEmpty());
		testerArrayDictionary.clear();
		assertTrue(testerArrayDictionary.isEmpty());
		
		// adds mappings to the dictionary
		for(int i = 0; i < strings.length; i++) {
			testerArrayDictionary.put(i, strings[i]);
		}
		
		// tests calling isEmpty on a nonempty dictionary
		assertFalse(testerArrayDictionary.isEmpty());
		testerArrayDictionary.clear();
		assertTrue(testerArrayDictionary.isEmpty());
	}
}
