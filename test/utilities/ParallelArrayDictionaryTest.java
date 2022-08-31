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
	
	private String[] strings = {"first", "second", "third", "fourth", "fifth"};
	
	@Test
	void testParallelArrayDictionary()
	{
	}

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

	@Test
	void testPut()
	{
		testerArrayDictionary.put(1, strings[1]);
		assertTrue(testerArrayDictionary.containsValue(strings[1]) && !testerArrayDictionary.isEmpty());
	}

	@Test
	void testRemove()
	{
		for(int i = 0; i < 5; i++)
			testerArrayDictionary.put(i+1, strings[i]);
		testerArrayDictionary.remove(2);
		assertTrue(!testerArrayDictionary.isEmpty() && !testerArrayDictionary.containsKey(2));
	}

	@Test
	void testPutAll()
	{
		Map<Integer, String> map = new Map<>();
		for(int i = 0; i < 5; i++)
			map.put(i, strings[i]);
		testerArrayDictionary.putAll(map);
	}

	@Test
	void testClear()
	{
		for(int i = 0; i < 5; i++)
			testerArrayDictionary.put(i+1, strings[i]);
		testerArrayDictionary.clear();
		assertTrue(testerArrayDictionary.isEmpty());
	}
}
