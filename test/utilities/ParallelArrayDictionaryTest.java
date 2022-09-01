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
	private static final ArrayList<String> STRINGS = 
			new ArrayList<>(Arrays.asList("zero", "one", "two", "three", "four"));
	
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
	 * tests get() by getting each value
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
	 *tests put() by replacing value 3
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
	}

	/**
	 * tests remove() by removing value 3
	 * */
	@Test
	void testRemove()
	{
		ParallelArrayDictionary<Integer, String> testRemove = 
				new ParallelArrayDictionary<>(INTEGERS, STRINGS);
		
		Integer removeKey = 3;
		Integer nullTest = 15;
		String removedValue = testRemove.remove(removeKey);
		
		assertEquals(removedValue, STRINGS.get(removeKey));
		assertNull(testRemove.remove(nullTest));
	}

	/**
	 * tests putAll() by creating a map and adding it to a dictionary
	 */
	@Test
	void testPutAll()
	{		
		ParallelArrayDictionary<Integer, String> testDic = new ParallelArrayDictionary<>();
		String[] additionalStrings = {"five", "six", "seven"};
		
		// creating a map and which is then passed as input
		Map<Integer, String> map = new ParallelArrayDictionary<>();
		for(int i = 0; i < STRINGS.size(); i++)
			map.put(i, STRINGS.get(i));
		testDic.putAll(map);
		
		// makes sure all key-value mappings have been added to the dictionary
		for (int i = 0; i < testDic.size(); i++) {

			assertTrue(testDic.containsKey(i) && testDic.get(i) == STRINGS.get(i));			
			assertTrue(testDic.containsKey(i));
			assertEquals(STRINGS.get(i), testDic.get(i));		
		}
		
		// clears the input map and adds new elements to it
		map.clear();
		
		assertTrue(map.isEmpty());
		for (int i = STRINGS.size(); i < additionalStrings.length + 5; i++)
			map.put(i, additionalStrings[i - STRINGS.size()]);

		for (int i = STRINGS.size(); i < additionalStrings.length + STRINGS.size(); i++) {
			map.put(i, additionalStrings[i - STRINGS.size()]);
		}
		
		// calls putAll(map) on a nonempty map
		testDic.putAll(map);

		// tests so that all key-value mappings have been added to the dictionary
		for (int i = STRINGS.size(); i < additionalStrings.length + 5; i++)
			assertTrue(testDic.containsKey(i) && testDic.get(i) == additionalStrings[i - STRINGS.size()]);

		// controls that all key-value mappings have been added to the dictionary
		for (int i = STRINGS.size(); i < additionalStrings.length + STRINGS.size(); i++) 
		{
			assertTrue(testDic.containsKey(i));
			assertEquals(additionalStrings[i - STRINGS.size()], testDic.get(i));
		}
	}

	/**
	 * tests clear() on both an empty dictionary and a nonempty dictionary
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
