package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{

	protected ArraySet<Key> _keys;
	protected ArrayList<Value> _values;
	
	@Override
	public int size() { return _keys.size(); }
	
	@Override
	public boolean isEmpty() { return _keys.isEmpty(); }
	
	@Override
	public boolean containsKey(Object key) { return _keys.contains(key); }
	
	@Override
	public boolean containsValue(Object value) { return _values.contains(value); }
	
	// TODO
	@Override
	public Value get(Object key) { 
		if (! _keys.contains(key)) {
			return null;
		}
		else {
			return _values.get(_keys.indexOf(key));
		}
	}

	@Override
	public Value put(Key key, Value value) { 
		if (_keys.contains(key)) {
			Value oldValue = _values.get(_keys.indexOf(key));
			_values.set(_keys.indexOf(key), value);
			return oldValue;
		}
		else {
			_keys.add(key);
			_values.add(value);
			return null;
		}
	}
	
	@Override
	public Value remove(Object key) {
		if (_keys.contains(key) ) {
			Value removedValue = _values.get(_keys.indexOf(key));
			_values.remove(_keys.indexOf(key));
			_keys.remove(_keys.indexOf(key));
			return removedValue;
		}
		else {
			return null;
		}
	}
	
	public void putAll(Map<? extends Key,? extends Value> m) {
		Set<Key> keySet = (Set<Key>) m.keySet();
		Iterator<Key> keyIterator = keySet.iterator();
		Key nextKey = keyIterator.next();
		while (keyIterator.hasNext()) {
			_keys.add(nextKey);
			_values.add(m.get(nextKey));
			nextKey = keyIterator.next();
		}
	}
	
	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}
	
	@Override
	public Set<Key> keySet() { return _keys; }
	
	@Override
	public Collection<Value> values() { return _values; }
	
	// TODO
	@Override
	public Set<Entry<Key, Value>> entrySet() {
		Set<Entry<Key, Value>>  setView = new ArraySet<Entry<Key, Value>>();
		for (int i = 0; i < _keys.size(); i++) {
			Entry<Key, Value> newEntry = new Entry<Key, Value>();
			setView.add(newEntry);
		}
	}

}
