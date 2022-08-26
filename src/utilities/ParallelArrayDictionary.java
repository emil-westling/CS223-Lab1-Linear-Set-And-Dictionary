package utilities;

import java.util.ArrayList;
import java.util.Collection;
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
	public Value get(Object key) { return _values.get(_keys.indexOf(key)); }

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
	public Value remove(Object key) 
	{
		if (_keys.contains(key)) 
		{
			Value value = _values.get(_keys.indexOf(key));
			_values.remove(value);
			return value;
		}
		
		return null;
	}
	
	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) 
	{
		
	}
	
	@Override
	public void clear() 
	{
		_keys.clear();
		_values.clear();	
	}
	
	@Override
	public Set<Key> keySet() 
	{
		if(! _keys.isEmpty()) 
		{
			Set<Key> keySet = new Set<Key>();
			
			keySet.addAll(_keys);
			
			/*for(int i = 0; i < _keys.size(); i++) 
			{
				keySet.add(_keys.get(i));
			}*/
			
			return keySet;
		}
		
		return null;
	}
	
	@Override
	public Collection<Value> values() 
	{
		if (! _values.isEmpty())
		{
			Collection<Value> valuesCollection = new Collection<Value>();
			
			valuesCollection.addAll(_values);
			
			return valuesCollection;
		}
		
		return null;
	}
	
	@Override
	public Set<Entry<Key, Value>> entrySet() 
	{
		//Map<K, V> entryMap = new Map<K, V>();
		
		return null;
	}
	

}
