package utilities;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{

	protected ArraySet<Key> _keys;
	protected ArrayList<Value> _values;
	
	public ParallelArrayDictionary() {	
		_keys = new ArraySet<>();
		_values = new ArrayList<Value>();
	}
	

	@Override
	public int size() { return _keys.size(); }
	
	@Override
	public boolean isEmpty() { return _keys.isEmpty(); }
	
	@Override
	public boolean containsKey(Object key) { return _keys.contains(key); }
	
	@Override
	public boolean containsValue(Object value) { return _values.contains(value); }
	
	@Override
	public Value get(Object key) 
	{ 
		if (! _keys.contains(key)) {
			return null;
		}
	    return _values.get(_keys.indexOf(key));
	}

	@Override
	public Value put(Key key, Value value) { 
		if (_keys.contains(key)) {
			Value oldValue = _values.get(_keys.indexOf(key));
			_values.set(_keys.indexOf(key), value);
			return oldValue;
		}
		_keys.add(key);
		_values.add(value);
		return null;
	}
	
	@Override
	public Value remove(Object key) {
		if (!_keys.contains(key) ) { return null; }
		Value removedValue = _values.get(_keys.indexOf(key));
		_values.remove(_keys.indexOf(key));
		_keys.remove(_keys.indexOf(key));
		return removedValue;
	}
	/**
	 * puts all key-value mappings in the specified map in this dictionary.
	 */
	public void putAll(Map<? extends Key,? extends Value> m) {
		for (Entry<? extends Key, ? extends Value> entry : m.entrySet()) {
			this.put(entry.getKey(), entry.getValue());
		}
	}
	
	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}
	
	/**
	 * @return set of all keys in the parallel array dictionary
	 */
	@Override
	public Set<Key> keySet() { return _keys; }
	
	/**
	 * @return a collection of all the values in the parallel array dictionary
	 */
	@Override
	public Collection<Value> values() { return _values; }
	
	/**
	 * @return a set view of all the mappings contained in this map
	 */
	@Override
	public Set<Entry<Key, Value>> entrySet() {
		Set<Entry<Key, Value>>  setView = new ArraySet<Entry<Key, Value>>();
		for (int i = 0; i < _keys.size(); i++) {
			Entry<Key, Value> newEntry = new SimpleEntry<Key, Value>(_keys.get(i), _values.get(i));
			setView.add(newEntry);
		}
		return setView;
	}

}
