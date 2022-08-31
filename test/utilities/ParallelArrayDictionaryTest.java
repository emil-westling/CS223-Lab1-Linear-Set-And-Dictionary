package utilities;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	ParallelArrayDictionary<Integer, String> testerArrayDictionary = new ParallelArrayDictionary<>();
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
		for(int i = 0; i < 5; i++)
			testerArrayDictionary.put(i+1, strings[i]);
		assertTrue(!testerArrayDictionary.isEmpty() && testerArrayDictionary.get(2) == strings[1]);
	}

	/**
	 * 
	 * */
	@Test
	void testPut()
	{
		testerArrayDictionary.put(1, strings[1]);
		assertTrue(testerArrayDictionary.containsValue(strings[1]) && !testerArrayDictionary.isEmpty());
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
