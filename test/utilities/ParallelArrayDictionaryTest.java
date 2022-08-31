package utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	ArrayList<String> values = new ArrayList<String>();
	ArraySet<Integer> keys = new ArraySet<Integer>();
	ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>(keys, values);

	private static  final String[] strings = {"first", "second", "third", "fourth", "fifth"};
	
	@Test
	void testParallelArrayDictionary()
	{
	}

	/**
	 * 
	 * */
	@Test
	void testGet()
	{
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
	 * 
	 * */
	@Test
	void testPut()
	{
		testerArrayDictionary.clear();
		assertTrue(testerArrayDictionary.size() == 0);
		
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
	 * 
	 * */
	@Test
	void testRemove()
	{
		for(int i = 0; i < 5; i++)
			testerArrayDictionary.put(i+1, strings[i]);
		testerArrayDictionary.remove(2);
		assertTrue(!testerArrayDictionary.isEmpty() && !testerArrayDictionary.containsKey(2));
	}

	/**
	 * 
	 * */
	@Test
	void testPutAll()
	{
		Map<Integer, String> map = new Map<>();
		for(int i = 0; i < 5; i++)
			map.put(i, strings[i]);
		testerArrayDictionary.putAll(map);
	}

	/**
	 * 
	 * */
	@Test
	void testClear()
	{
		for(int i = 0; i < 5; i++)
			testerArrayDictionary.put(i+1, strings[i]);
		testerArrayDictionary.clear();
		assertTrue(testerArrayDictionary.isEmpty());
	}
}
